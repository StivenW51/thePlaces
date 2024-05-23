package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.File;

public record ComentarioDTO(
        @NotBlank @NotNull
        String codigoNegocio,
        @NotBlank @NotNull
        String codigoCliente,
        @NotBlank @NotNull
        String mensaje,
        @NotNull @Max(5) @Min(1)
        int calificacion,
        //private CodigoDescuento bono,
        File urlFotoComentario
) {
}
