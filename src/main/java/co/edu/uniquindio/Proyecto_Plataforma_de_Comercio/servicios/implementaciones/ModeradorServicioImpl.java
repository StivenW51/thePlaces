package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.CambioEstadoRegistroDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.RegistroModeradorRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ModeradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final RegistroModeradorRepo registroModeradorRepo;
    private final NegocioServicioImpl negocioServicio;

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
    }
}
