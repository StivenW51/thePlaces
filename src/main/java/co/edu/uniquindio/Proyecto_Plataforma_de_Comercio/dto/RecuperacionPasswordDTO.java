package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RecuperacionPasswordDTO(
        @NotBlank @Email
        String email,

        @NotBlank
        String password
) {
}
