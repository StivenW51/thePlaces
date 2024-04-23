package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record ActualizacionUsuarioDTO(
        @NotBlank
        String codigo,

        @NotBlank
        @NotNull
        String idCuenta,

        @NotBlank
        @Length(max = 100)
        String nombre,

        @NotBlank
        @Length(max = 100)
        String apellido,

        @NotBlank
        String fotoPerfil,

        @NotBlank
        @Length(max = 100)
        @Email
        String email,

        @NotBlank
        @Length(max = 50)
        String ciudadResidencia,

        @NotNull
        List<String>telefono,

        @NotBlank
        String token
) {
}
