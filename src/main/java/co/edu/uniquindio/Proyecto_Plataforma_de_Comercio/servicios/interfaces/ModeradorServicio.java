package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioRevisadoDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EstadoRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;

import java.util.List;

public interface ModeradorServicio {
    void revisarNegocio(DetalleRegistroModeradorDTO detalleRegistroModeradorDTO) throws Exception;

    List<DetalleNegocioRevisadoDTO> listarNegociosRevisadosModerador(EstadoRegistroModeradorDTO estadoRegistroModeradorDTO) throws Exception;
}
