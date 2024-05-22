package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.TokenDTO;

public interface AutenticacionServicio {

    void recuparContrasenna(String email) throws Exception;
    public TokenDTO IniciarSesion(InicioSesionDTO loginDTO) throws Exception;

}
