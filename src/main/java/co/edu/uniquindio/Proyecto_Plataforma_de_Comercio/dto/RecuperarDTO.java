package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RecuperarDTO(
       @NotBlank @Email
       String email,
       @NotBlank
       String url
) {

}
