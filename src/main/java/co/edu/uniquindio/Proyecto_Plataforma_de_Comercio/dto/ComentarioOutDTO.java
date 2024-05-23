package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ComentarioOutDTO(

        @NotBlank @NotNull
        String codigoCliente,
        @NotBlank @NotNull
        String mensaje,

        //private CodigoDescuento bono,
        String urlFotoComentario,

        RespuestaOutDTO respuesta,

        LocalDateTime fecha
) {
}
