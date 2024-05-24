package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RecuperarDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.TokenDTO;

public interface AutenticacionServicio {

    void recuparContrasenna(RecuperarDTO recuperarDTO) throws Exception;
    public TokenDTO IniciarSesion(InicioSesionDTO loginDTO) throws Exception;

}
