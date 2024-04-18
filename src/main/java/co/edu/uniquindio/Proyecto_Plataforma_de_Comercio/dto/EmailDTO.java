package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailDTO (
        @NotBlank @NotNull
        String asunto,
        @NotBlank @NotNull
        String cuerpo,
        @NotBlank @NotNull @Email
        String destinatario
){
}
