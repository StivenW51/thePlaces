package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetalleRegistroModeradorDTO(
        @NotBlank
        String idNegocio,
        @NotBlank
        String idModerador,
        @NotNull
        EstadoRegistro estadoRegistro,
        String observacion,

        LocalDate fechaRegistro
) {
}
