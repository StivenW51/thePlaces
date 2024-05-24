package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public record RegistroCuentaDTO (
        @NotBlank
        @Length(max = 100)
        @Email
        String email,

        @NotBlank
        @Length(max = 10)
        String nickname,

        @NotBlank
        @Length(min = 8)
        String password,
        String fotoPerfil,
        @NotBlank
        boolean estadoRegistro
){
}
