package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString(callSuper = true)
@Document("moderadores")
@NoArgsConstructor
public class Moderador {

    private String codigo;
    private String nombre;
    private String idCuenta;
}
