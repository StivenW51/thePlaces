package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.test;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.CrearNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Horario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Ubicacion;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class NegocioServicioTest {

    @Autowired
    private NegocioServicio negocioServicio;

    @Test
    public void crerNegocioTest() throws Exception{
        CrearNegocioDTO crearNegocioDTO = new CrearNegocioDTO(
                "Intermedia",
                TipoNegocio.BAR,
                "que le importa sapo",
                "hidraulica",
                new ArrayList<String>(Arrays.asList("imagen1","imagen2")),
                new Ubicacion(34.465, -15858.234),
                new ArrayList<Horario>(Arrays.asList(new Horario("Lunes","08:00","18:00"))),
                EstadoRegistro.PENDIENTE,
                EstadoNegocio.ACTIVO,
                new ArrayList<String>(Arrays.asList("13245","0000000")),
                "66209a3adf1d017a38b47ba0"
        );

        negocioServicio.crearNegocio(crearNegocioDTO);
    }
}
