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

public record DetalleNegocioDTO(

        @NotBlank
        String id,

        @NotBlank @Length(max = 100)
        String nombreNegocio,

        @NotBlank @Length (max = 100)
        String direccion,

        @NotNull
        List<Horario> horarios,

        @NotNull
        Ubicacion ubicacion,

        @NotNull
        TipoNegocio categoria,


        @NotNull
        List<String> imagenes,

        @NotNull
        List<String> telefonos,

        @NotBlank @Length (max = 200)
        String descripcion,

        String idPropietario,

        Integer calificacion,

        EstadoNegocio estadoNegocio,

        EstadoRegistro estadoRegistro,

        String idModerador
) {
}
