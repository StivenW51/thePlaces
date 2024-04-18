package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ClienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @PostMapping("/registrar-cliente")
    public ResponseEntity<MensajeDTO<String>> registrarCliente(@Valid @RequestBody
                                                               RegistroUsuarioDTO registroClienteDTO)throws Exception{
        clienteServicio.registroCliente(registroClienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cliente registrado correctamente")
        );
    }

    @GetMapping("/obtener/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleClienteDTO>> obtenerCliente(@PathVariable String
                                                                                codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clienteServicio.obtenerCliente(codigo) ) );
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable String codigo)throws
            Exception{
        clienteServicio.eliminarCliente(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cliente eliminado correctamente")
        );
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<MensajeDTO<List<ItemClienteDTO>>> listarClientes(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clienteServicio.listarClientes() )
        );
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> actualizarCliente(@Valid @RequestBody
                                                                ActualizacionUsuarioDTO actualizacionUsuarioDTO)throws Exception{
        clienteServicio.actualizarPerfil(actualizacionUsuarioDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cliente actualizado correctamente") );
    }

}
