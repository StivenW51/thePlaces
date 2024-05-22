package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;

import java.util.List;

public interface PublicoServicio {
    String registroCliente(RegistroUsuarioDTO registroUsuarioDTO) throws Exception;
    List<DetalleNegocioDTO> listarNegociosActivosAprobados() throws Exception;
}
