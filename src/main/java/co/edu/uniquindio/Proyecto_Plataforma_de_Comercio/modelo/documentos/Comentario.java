package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Respuesta;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document("comentarios")
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String codigoNegocio;
    private String codigoCliente;
    private String mensaje;
    private int calificacion;
    private LocalDateTime fecha;
    //private CodigoDescuento bono;
    private String urlFotoComentario;
    private Respuesta respuesta;

    @Builder
    public Comentario(String codigo, String codigoNegocio,
                      String codigoCliente, String mensaje,
                      int calificacion, LocalDateTime fecha,
                      String urlFotoComentario, Respuesta respuesta) {
        this.codigo = codigo;
        this.codigoNegocio = codigoNegocio;
        this.codigoCliente = codigoCliente;
        this.mensaje = mensaje;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.urlFotoComentario = urlFotoComentario;
        this.respuesta = respuesta;
    }
}


