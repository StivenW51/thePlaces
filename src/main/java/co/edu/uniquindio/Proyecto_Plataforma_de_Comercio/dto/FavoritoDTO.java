package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FavoritoDTO(

        @NotBlank @NotNull
        String idCliente,

        @NotBlank @NotNull
        String idNegocio
) {
}
