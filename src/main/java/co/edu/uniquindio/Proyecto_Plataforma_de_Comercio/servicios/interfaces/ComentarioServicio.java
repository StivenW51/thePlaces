package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.ComentarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.ComentarioOutDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RespuestaDTO;

import java.util.List;

public interface ComentarioServicio {

    void registrarComentario(ComentarioDTO comentarioDTO) throws Exception; //cliente

    void responderComentario(RespuestaDTO respuestaDTO) throws Exception; //cliente


    List<ComentarioOutDTO> listarComentariosNegocio(String IdNegocio) throws Exception; //public

    int calificacionNegocio(String idNegocio) throws Exception; //publico
}
