package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Horario {
    String dia;
    String horaInicio;
    String horaFinal;
}
