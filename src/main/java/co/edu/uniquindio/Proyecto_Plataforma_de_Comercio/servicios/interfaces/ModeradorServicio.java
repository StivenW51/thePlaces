package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;

public interface ModeradorServicio {
    void revisarNegocio(DetalleRegistroModeradorDTO detalleRegistroModeradorDTO) throws Exception;
}
