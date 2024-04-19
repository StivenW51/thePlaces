package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Horario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Ubicacion;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CrearNegocioDTO(
        @NotBlank @Length (max = 100)
        String nombre,

        @NotNull
        TipoNegocio tipoNegocio,

        @NotBlank @Length (max = 200)
        String descripcion,

        @NotBlank @Length (max = 100)
        String direccion,

        @NotNull
        List<String> imagenes,

        @NotNull
        Ubicacion ubicacion,

        @NotNull
        List<Horario> horarios,

        @NotNull
        EstadoRegistro estadoRegistro,

        @NotNull
        EstadoNegocio estadoNegocio,

        @NotNull
        List<String> telefonos,

        @NotBlank
        String codigoCliente,

        String idModerador
) {
}
