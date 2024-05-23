package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
public class Respuesta {
    private String mensaje;
    private LocalDateTime fecha;

    @Builder
    public Respuesta(String mensaje, LocalDateTime fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }
}

