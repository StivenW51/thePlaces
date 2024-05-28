package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroCuentaDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ClienteRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.CuentaRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.NegocioRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.PublicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PublicoServicioImpl implements PublicoServicio {

    private final ClienteRepo clienteRepo;
    private final CuentaRepo cuentaRepo;
    private final CuentaServicioImpl cuentaServicio;
    private final ClienteServicioImpl clienteServicio;
    private final NegocioRepo negocioRepo;
    private final NegocioServicioImpl negocioServicio;

    @Override
    public String registroCliente(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {

        //creamos el objeto cliente
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();

        //verificamos que la cedula sea unica
        if(clienteServicio.existeCedula(registroUsuarioDTO.cedula())){
            throw new Exception("La Cedula ya se encuentra registrada");
        }

        RegistroCuentaDTO registroCuentaDTO = new RegistroCuentaDTO(registroUsuarioDTO.email(),
                registroUsuarioDTO.nickname(),
                registroUsuarioDTO.password(),
                registroUsuarioDTO.fotoPerfil(),
                true ) ;
        cuentaServicio.crearCuenta(registroCuentaDTO);
        cuenta = cuentaServicio.obtenerCuentaPorEmail(registroCuentaDTO.email());

        //asignamos los campos de cada atributo
        cliente.setCedula(registroUsuarioDTO.cedula());
        cliente.setNombre(registroUsuarioDTO.nombre());
        cliente.setApellido(registroUsuarioDTO.apellido());
        cliente.setCiudad(registroUsuarioDTO.ciudadResidencia());
        cliente.setTelefono(registroUsuarioDTO.telefono());

        cliente.setIdCuenta(cuenta.getId());

        //Guardamos en la base de datos y obtenemos el objeto registrado
        Cliente clienteGuardado = clienteRepo.save(cliente);

        //retornamos el id (codigo) del cliente registrado
        return clienteGuardado.getCodigo();
    }

    @Override
    public List<DetalleNegocioDTO> listarNegociosActivosAprobados() throws Exception {
        List<Negocio> listaNegocios = new ArrayList<>();
        Optional<List<Negocio>> optionalNegocios = negocioRepo.findByEstadoNegocioAndEstadoRegistro(EstadoNegocio.ACTIVO, EstadoRegistro.APROBADO);
        List<DetalleNegocioDTO> listaDetalleNegocio = new ArrayList<>();
        Negocio negocio;

        if(optionalNegocios.isEmpty()){
            throw new Exception("No hay negocios");
        }

        listaNegocios = optionalNegocios.get();

        for(int i = 0; i < listaNegocios.size(); i++){
            negocio = listaNegocios.get(i);

            listaDetalleNegocio.add(new DetalleNegocioDTO(
                    negocio.getCodigo(),
                    negocio.getNombre(),
                    negocio.getDireccion(),
                    negocio.getHorarios(),
                    negocio.getUbicacion(),
                    negocio.getTipoNegocio(),
                    negocio.getImagenes(),
                    negocio.getTelefonos(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente(),
                    negocioServicio.Calificacion(negocio.getCodigo()),
                    negocio.getEstadoNegocio(),
                    negocio.getEstadoRegistro(),
                    negocio.getIdModerador()
            ));
        }

        return listaDetalleNegocio;
    }

}
