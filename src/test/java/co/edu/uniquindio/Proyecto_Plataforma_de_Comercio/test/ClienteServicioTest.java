package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.test;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones.ClienteServicioImpl;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    public void registroClienteTest() throws Exception{
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO(
                "1094932425",
                "Stiven",
                "Restrepo",
                "stivenw51",
                "stivenavs56@gmail.com",
                "Armenia",
                "jsr.1956",
                "xxx");

        //Se registra el cliente
        String codigo = clienteServicio.registroCliente(registroUsuarioDTO);

        //se verifica que el codigo no sea nulo, es decir, que se haya registrado correctamente el cliente
        Assertions.assertNotNull(codigo);
    }

    @Test
    public void actualizarClienteTest() throws Exception{
        List<String> telefonos = new ArrayList<>();
        telefonos.add("3148327291");

        ActualizacionUsuarioDTO actualizacionUsuarioDTO = new ActualizacionUsuarioDTO(
                "66209a3adf1d017a38b47ba0",
                "66209a3adf1d017a38b47b9f",
                "Jhon Stiven",
                "Restrepo Ramirez",
                "yyyyyy",
                "stivenavs@gmail.com",
                "Armenia - Quindio",
                telefonos,
                "dfgdfgfdgksjdnbkljhfuh");

        //Se registra el cliente
        clienteServicio.actualizarPerfil(actualizacionUsuarioDTO);
    }

    @Test
    public void eliminarPerfil() throws Exception{
        clienteServicio.eliminarPerfil("66209a3adf1d017a38b47ba0");
    }


}
