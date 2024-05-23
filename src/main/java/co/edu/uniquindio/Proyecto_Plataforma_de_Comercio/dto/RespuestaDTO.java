package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @NotBlank @NotNull
        String idComentario,
        @NotBlank @NotNull
        String mensaje
) {
}
