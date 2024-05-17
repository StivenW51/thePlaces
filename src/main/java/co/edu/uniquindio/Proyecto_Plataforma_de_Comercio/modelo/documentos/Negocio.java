package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Horario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Ubicacion;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document("negocios")
public class Negocio implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String nombre;
    private TipoNegocio tipoNegocio;
    private String descripcion;
    private String direccion;
    private List<String> imagenes;
    private Ubicacion ubicacion;
    private List<Horario> horarios;
    private EstadoRegistro estadoRegistro;
    private EstadoNegocio estadoNegocio;
    private List<String> telefonos;
    private String codigoCliente; // Codigo del cliente propietario
    private String idModerador;
}
