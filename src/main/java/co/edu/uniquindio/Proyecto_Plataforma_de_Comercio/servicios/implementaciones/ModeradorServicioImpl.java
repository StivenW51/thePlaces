package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.RegistroModeradorRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ModeradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<DetalleNegocioRevisadoDTO> listarNegociosRevisadosModerador(EstadoRegistroModeradorDTO estadoRegistroModeradorDTO) throws Exception {
        List<RegistroModerador> registrosModeradores = new ArrayList<>();
        Optional<List<RegistroModerador>> optionalRegistrosModeradores = registroModeradorRepo.findByIdModeradorAndEstadoRegistro(estadoRegistroModeradorDTO.idModerador(), estadoRegistroModeradorDTO.estadoRegistro());
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

}
