package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.TokenDTO;

public interface AutenticacionServicio {
    public TokenDTO iniciarSesionCliente(InicioSesionDTO loginDTO) throws Exception;
    public TokenDTO iniciarSesionModerador(InicioSesionDTO loginDTO) throws Exception;
    void recuparContrasenna(String email) throws Exception;
}
