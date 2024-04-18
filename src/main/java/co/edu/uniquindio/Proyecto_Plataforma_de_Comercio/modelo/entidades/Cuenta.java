package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoCliente;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document("cuentas")
public class Cuenta {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String email;
    private String nickname;
    private String password;
    private String fotoPerfil;
    private EstadoCliente estadoCliente;
}
