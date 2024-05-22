package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ClienteRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.CuentaRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServicioImpl implements ClienteServicio {

    private final ClienteRepo clienteRepo;
    private final CuentaRepo cuentaRepo;
    private final CuentaServicioImpl cuentaServicio;
    private final NegocioServicioImpl negocioServicio;


    public boolean existeCedula(String cedula){
        return clienteRepo.findByCedula(cedula).isPresent();
    }

    @Override
    public void actualizarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception {
        //Buscamos el cliente a actualizar
        //traerCodigoCliente(actualizacionUsuarioDTO.id());
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(actualizacionUsuarioDTO.codigo());
        Cuenta cuenta = cuentaServicio.obtenerCuentaPorId(actualizacionUsuarioDTO.idCuenta());

        Cliente cliente = optionalCliente.get();

        //Excepcion por si no encontramos el cliente
        if (optionalCliente.isEmpty()){
            throw new Exception("No se encontro el cliente a actualizar");
        }

        if (cuentaServicio.existeEmail(actualizacionUsuarioDTO.email())){
            if(!cuenta.getEmail().equals(actualizacionUsuarioDTO.email())){
                throw new Exception("El email ingresado ya se encuentra en uso");
            }
        }

        //si encontramos el cliente, entonces obtenemos el cliente a actualizar y le asignamos los nuevos valores.
        cliente.setNombre(actualizacionUsuarioDTO.nombre());
        cliente.setApellido(actualizacionUsuarioDTO.apellido());
        cliente.setCiudad(actualizacionUsuarioDTO.ciudadResidencia());
        cliente.setTelefono(actualizacionUsuarioDTO.telefono());

        ActualizarCuentaDTO actualizarCuentaDTO = new ActualizarCuentaDTO(actualizacionUsuarioDTO.idCuenta(),
                actualizacionUsuarioDTO.email(), actualizacionUsuarioDTO.fotoPerfil(),actualizacionUsuarioDTO.token());

        //actualizamos el email de la cuenta
        cuentaServicio.actualizarCuenta(actualizarCuentaDTO);

        //como el objeto cliente ya tiene un id, el save() no crea un nuevo registro sino que actualiza el que ya existe
        clienteRepo.save(cliente);

    }

    @Override
    public void eliminarPerfil(String idCliente) throws Exception {

        //buscamos el cliente que se quiere eliminar
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(idCliente);

        //sino se encuentra el cliente lanzamos una excepcion
        if (optionalCliente.isEmpty()) {
            throw new Exception("El cliente no se ha encontrado");
        }

        //si encontramos el cliente entonces lo obtenemos y le cambiamos el estado a inactivo
        Cliente cliente = optionalCliente.get();

        cuentaServicio.inactivarCuenta(cliente.getIdCuenta());
    }

    @Override
    public void iniciarSesion(InicioSesionDTO inicioSesionDTO) throws Exception {

        Optional<Cuenta> optionalCuenta = cuentaRepo.findByEmail(inicioSesionDTO.email());
        if (optionalCuenta.isEmpty()) {
            throw new Exception("cliente no existe");
        }
        else {
            if(inicioSesionDTO.password().equals(optionalCuenta.get().getPassword())){

            }
            else{
                throw new Exception("Contraseña incorrecta");
            }
        }

    }

    @Override
    public void enviarLinkRecuparcion(String email) throws Exception {

    }

    @Override
    public void recuperarPassword(RecuperacionPasswordDTO recuperacionPasswordDTO) throws Exception {

    }

    @Override
    public DetalleClienteDTO obtenerCliente(String idCliente) throws Exception {

        //Buscamos el cliente que queremos mostrar
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(idCliente);

        if (optionalCliente.isEmpty()){
            throw new Exception("El Cliente con el id " + idCliente + " no se ha encontrado");
        }

        //si se encuentra el cliente encontra lo traemos con el get
        Cliente cliente = optionalCliente.get();
        Cuenta cuenta = cuentaServicio.obtenerCuentaPorId(cliente.getIdCuenta());

        //Retornamos el cliente en formato DTO
        return new DetalleClienteDTO(cliente.getCodigo(),
                cliente.getNombre() + " " + cliente.getApellido(),
                cuenta.getFotoPerfil(),
                cuenta.getNickname(),
                cuenta.getEmail(),
                cliente.getCiudad(),
                cliente.getIdCuenta());
    }

    @Override
    public List<ItemClienteDTO> listarClientes() {

        //obtenemos todos los clientes de la base de datos
        List<Cliente> clientes = clienteRepo.findAll();

        //creamos una lista de DTOs de clientes
        List<ItemClienteDTO> items = new ArrayList<>();

        //recorremos la lista de clientes y por cada uno creamos un DTO y lo agregamos a la lista
        for (Cliente cliente : clientes){
            items.add(null); //new ItemClienteDTO(cliente.getCodigo(), cliente.getNombre(), cliente.getApellido(), cliente.getCuenta().getEmail(), cliente.getCuenta().getNickname(), cliente.getCiudad(), cliente.getFotoPerfil()));
        }

        return items;
    }

    @Override
    public List<DetalleNegocioDTO> listarFavoritos(String idCliente) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(idCliente);
        List<DetalleNegocioDTO> listDetalleNegocioDTO = new ArrayList<>();
        Negocio negocio;

        Cliente cliente = optionalCliente.get();
        List<String> favoritos = cliente.getFavoritos();

        for(String idNegocio : favoritos){
            listDetalleNegocioDTO.add(negocioServicio.obtenerNegocioCodigo(idNegocio));
        }

        return listDetalleNegocioDTO;
    }

    @Override
    public void AgregarFavorito(FavoritoDTO favoritoDTO) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(favoritoDTO.idCliente());
        Cliente cliente = optionalCliente.get();

        List<String> favoritos = cliente.getFavoritos();

        for(String idNegocio : favoritos){
            if(idNegocio.equals(favoritoDTO.idNegocio())){
                throw new Exception("Favorito ya existe");
            }
        }

        favoritos.add(favoritoDTO.idNegocio());
        cliente.setFavoritos(favoritos);

        clienteRepo.save(cliente);
    }

    @Override
    public void QuitarFavorito(FavoritoDTO favoritoDTO) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepo.findByCodigo(favoritoDTO.idCliente());
        Cliente cliente = optionalCliente.get();

        List<String> favoritos = cliente.getFavoritos();
        //List<String> favoritosBK = favoritos;

        for(String idNegocio : favoritos){
            if(idNegocio.equals(favoritoDTO.idNegocio())){
                favoritos.remove(favoritoDTO.idNegocio());
                break;
            }
        }

        cliente.setFavoritos(favoritos);
        clienteRepo.save(cliente);
    }


}
