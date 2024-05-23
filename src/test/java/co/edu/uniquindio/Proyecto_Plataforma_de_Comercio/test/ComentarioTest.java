package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.test;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Respuesta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    public void crearComentario(){
        Comentario comentario = Comentario.builder()
                .codigoNegocio("66218a1784612825e5995b1d")
                .codigoCliente("6628361ed808532e1bef9d57")
                .mensaje("Hola BAR-MASTUR que buen serivcio, te mando una foto")
                .calificacion(5)
                .fecha(LocalDateTime.now())
                .urlFotoComentario("c:\\Users\\Stiven Restrepo\\Pictures\\Delicias de JACOBO\\20200815_222549.jpg")
                .respuesta(Respuesta.builder()
                        .mensaje("Gracias putito")
                        .fecha(LocalDateTime.now())
                        .build())
                .build();

        Comentario registro = comentarioRepo.save(comentario);

        Assertions.assertNotNull(registro);
    }
}