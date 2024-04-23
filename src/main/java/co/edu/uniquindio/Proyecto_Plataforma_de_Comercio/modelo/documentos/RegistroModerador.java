package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@ToString(callSuper = true)
@Document("registros_moderadores")
@NoArgsConstructor
@AllArgsConstructor
public class RegistroModerador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String idNegocio;
    private String idModerador;
    private EstadoRegistro estadoRegistro;
    private String Observacion;
    private LocalDate fechaRegistro;

}
