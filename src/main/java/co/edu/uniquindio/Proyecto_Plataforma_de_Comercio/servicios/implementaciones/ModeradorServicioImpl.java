package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.RegistroModeradorRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ModeradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final RegistroModeradorRepo registroModeradorRepo;
    private final NegocioServicioImpl negocioServicio;
    private final EmailServicioImpl emailServicio;
    private final ClienteServicioImpl clienteServicio;
    private final CuentaServicioImpl cuentaServicio;
    @Override
    public void revisarNegocio(DetalleRegistroModeradorDTO detalleRegistroModeradorDTO) throws Exception {
        RegistroModerador registroModerador = new RegistroModerador();
        EstadoNegocio estadoNegocio;

        registroModerador.setIdNegocio(detalleRegistroModeradorDTO.idNegocio());
        registroModerador.setIdModerador(detalleRegistroModeradorDTO.idModerador());
        registroModerador.setEstadoRegistro(detalleRegistroModeradorDTO.estadoRegistro());
        registroModerador.setFechaRegistro(LocalDate.now());

        if(detalleRegistroModeradorDTO.estadoRegistro().equals(EstadoRegistro.RECHAZADO)){
            estadoNegocio = EstadoNegocio.INACTIVO;
            registroModerador.setObservacion(detalleRegistroModeradorDTO.observacion());
        }
        else{
            estadoNegocio = EstadoNegocio.ACTIVO;
            registroModerador.setObservacion("");
        }

        CambioEstadoRegistroDTO cambioEstadoRegistroDTO = new CambioEstadoRegistroDTO(
                detalleRegistroModeradorDTO.idNegocio(),
                detalleRegistroModeradorDTO.estadoRegistro(),
                estadoNegocio);

        registroModeradorRepo.save(registroModerador);
        negocioServicio.CambiarEstadoRegistro(cambioEstadoRegistroDTO);
        enviarCorreoModerador(detalleRegistroModeradorDTO);
    }

    @Override
    public List<DetalleNegocioRevisadoDTO> listarNegociosRevisadosModerador(String idModerador, String estadoRegistro) throws Exception {
        List<RegistroModerador> registrosModeradores = new ArrayList<>();
        Optional<List<RegistroModerador>> optionalRegistrosModeradores = registroModeradorRepo.findByIdModeradorAndEstadoRegistro(idModerador, estadoRegistro);
        List<DetalleNegocioRevisadoDTO> listaDetalleRegistros = new ArrayList<>();
        DetalleNegocioDTO detalleNegocioDTO;

        if(optionalRegistrosModeradores.isEmpty()){
            throw new Exception("El moderador no ha revisado negocios");
        }

        registrosModeradores = optionalRegistrosModeradores.get();

        if(registrosModeradores.isEmpty()){
            throw new Exception("El moderador no ha revisado negocios");
        }

        for(RegistroModerador registroModerador : registrosModeradores){
            detalleNegocioDTO = negocioServicio.obtenerNegocioCodigo(registroModerador.getIdNegocio());

            listaDetalleRegistros.add(new DetalleNegocioRevisadoDTO(
                                        detalleNegocioDTO.id(),
                                        detalleNegocioDTO.nombreNegocio(),
                                        detalleNegocioDTO.descripcion(),
                                        detalleNegocioDTO.horarios(),
                                        detalleNegocioDTO.ubicacion(),
                                        detalleNegocioDTO.categoria(),
                                        detalleNegocioDTO.imagenes(),
                                        detalleNegocioDTO.telefonos(),
                                        detalleNegocioDTO.descripcion(),
                                        registroModerador.getObservacion())
            );
        }

        return listaDetalleRegistros;
    }


    private void enviarCorreoModerador(DetalleRegistroModeradorDTO detalleRegistroModeradorDTO) throws Exception {
        String mensaje = "";
        DetalleNegocioDTO negocio = negocioServicio.obtenerNegocioCodigo(detalleRegistroModeradorDTO.idNegocio());
        DetalleClienteDTO cliente = clienteServicio.obtenerCliente(negocio.idPropietario());
        Cuenta cuenta = cuentaServicio.obtenerCuentaPorId(cliente.idCuenta());

        mensaje += "Estimado " + cliente.nombre();
        mensaje += "<br> <br> Su negocio ha sido " + detalleRegistroModeradorDTO.estadoRegistro().toString();
        mensaje += "<br> y los detalles se encuentran a continuación";
        mensaje += "<br> <br> Observaciones: ";
        mensaje += detalleRegistroModeradorDTO.observacion();
        mensaje += "<br> <br> muchas gracias <br> Equipo <strong>The Places</strong>";

        emailServicio.enviarCorreo(new EmailDTO("Su negocio ha sido "+ detalleRegistroModeradorDTO.estadoRegistro().toString()
                ,mensaje, cuenta.getEmail()));
    }
}
