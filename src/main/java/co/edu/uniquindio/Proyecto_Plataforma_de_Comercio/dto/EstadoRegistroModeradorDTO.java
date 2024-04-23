package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstadoRegistroModeradorDTO(
        @NotBlank
        String idModerador,
        @NotNull
        EstadoRegistro estadoRegistro
) {
}
