package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.test;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EmailDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.EmailServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServicioTest {

    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarCorreoTest() throws Exception{
        EmailDTO emailDTO = new EmailDTO("Hola", "Como el de Jonathan", "stivenavs@gmail.com");
        emailServicio.enviarCorreo(emailDTO);
    }
}
