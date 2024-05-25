package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString(callSuper = true)
@Document("moderadores")
@NoArgsConstructor
public class Moderador {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String nombre;
    private String idCuenta;
}
