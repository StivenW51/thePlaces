package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Respuesta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ComentarioRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ComentarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final ImagenesServicioImpl imagenesServicio;

    @Override
    public void registrarComentario(ComentarioDTO comentarioDTO) throws Exception{
        Comentario comentario = Comentario.builder()
                .codigoNegocio(comentarioDTO.codigoNegocio())
                .codigoCliente(comentarioDTO.codigoCliente())
                .mensaje(comentarioDTO.mensaje())
                .calificacion(comentarioDTO.calificacion())
                .fecha(LocalDateTime.now())
                .urlFotoComentario("")
                .build();

        File uploadedFile = comentarioDTO.urlFotoComentario();
        Map cloudinaryResponse = imagenesServicio.subirImagenII(uploadedFile);
        String urlCloudinary = cloudinaryResponse.get("url").toString();
        comentario.setUrlFotoComentario(urlCloudinary);

        Comentario registro = comentarioRepo.save(comentario);
    }

    @Override
    public void responderComentario(RespuestaDTO respuestaDTO) throws Exception {
        Optional<Comentario> optionalComentario = comentarioRepo.findById(respuestaDTO.idComentario());

        if(optionalComentario.isEmpty()){
            throw new Exception("Error de comentario");
        }

        Comentario comentario = optionalComentario.get();
        comentario.setRespuesta(Respuesta.builder()
                .mensaje(respuestaDTO.mensaje())
                .fecha(LocalDateTime.now())
                .build());

        Comentario registro = comentarioRepo.save(comentario);
    }

    @Override
    public List<ComentarioOutDTO> listarComentariosNegocio(String idNegocio) throws Exception {
        List<Comentario> listaComentarios = new ArrayList<>();
        Optional<List<Comentario>> optionalComentarios = comentarioRepo.findByCodigoNegocio(idNegocio);
        List<ComentarioOutDTO> listaComentarioDTO = new ArrayList<>();
        Comentario comentario;

        if(optionalComentarios.isEmpty()){
            throw new Exception("el negocio no tiene comentarios");
        }

        listaComentarios = optionalComentarios.get();
        if(listaComentarios.isEmpty()){
            throw new Exception("el negocio no tiene comentarios");
        }

        for(int i = 0; i < listaComentarios.size(); i++){
            comentario = listaComentarios.get(i);

            listaComentarioDTO.add(new ComentarioOutDTO(
                    comentario.getCodigoCliente(),
                    comentario.getMensaje(),
                    comentario.getUrlFotoComentario(),
                    new RespuestaOutDTO(comentario.getRespuesta().getMensaje(),
                                        comentario.getRespuesta().getFecha()),
                    comentario.getFecha()
            ));
        }

        return listaComentarioDTO;
    }

    @Override
    public int calificacionNegocio(String idNegocio) throws Exception{
        List<Comentario> listaComentarios;
        Optional<List<Comentario>> optionalComentarios = comentarioRepo.findByCodigoNegocio(idNegocio);
        int calificacionNegocio = 0;
        double calificacionAcum = 0;

        if(optionalComentarios.isEmpty()){
            throw new Exception("el negocio no tiene calificaciones");
        }

        listaComentarios = optionalComentarios.get();
        if(listaComentarios.isEmpty()){
            throw new Exception("el negocio no tiene calificaciones");
        }

        for(int i = 0; i < listaComentarios.size(); i++){
            calificacionAcum += listaComentarios.get(i).getCalificacion();
        }

        calificacionNegocio = (int)Math.ceil(calificacionAcum/listaComentarios.size());

        return calificacionNegocio;
    }
}
