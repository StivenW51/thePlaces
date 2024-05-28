package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.utils.FiltroToken;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServicio clienteServicio;
    private final ComentarioServicio comentarioServicio;


    @GetMapping("/obtener/{codigo}")
    public ResponseEntity<MensajeDTO<Object>> obtenerCliente(@PathVariable String codigo) throws Exception {

        try{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, clienteServicio.obtenerCliente(codigo) ) );
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable String codigo) throws Exception{
        try{
            clienteServicio.eliminarPerfil(codigo);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Cliente eliminado correctamente"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<ItemClienteDTO>>> listarClientes(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false, clienteServicio.listarClientes() )
        );
    }

    @PutMapping("/editar")
    public ResponseEntity<MensajeDTO<String>> actualizarCliente(@Valid @RequestBody ActualizacionUsuarioDTO actualizacionUsuarioDTO) throws Exception{

        try{
            clienteServicio.actualizarPerfil(actualizacionUsuarioDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Cliente actualizado correctamente"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/favoritos/{idCliente}")
    public ResponseEntity<MensajeDTO<Object>> listarFavoritos(@PathVariable String idCliente) throws Exception {

        try{
            return ResponseEntity.ok().body(
                new MensajeDTO<>(false, clienteServicio.listarFavoritos(idCliente)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PostMapping(value = "/agregarfavorito")
    public ResponseEntity<MensajeDTO<Object>> agregarFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        try{
            clienteServicio.AgregarFavorito(favoritoDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Favorito Agregado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PostMapping(value = "/quitarFavorito")
    public ResponseEntity<MensajeDTO<Object>> quitarFavorito(@Valid @RequestBody FavoritoDTO favoritoDTO) throws Exception {
        try{
            clienteServicio.QuitarFavorito(favoritoDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Favorito quitado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }


    //SECCION DE  COMENTARIOS
    @PostMapping(value = "/agregar-comentario")
    public ResponseEntity<MensajeDTO<Object>> agregarComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception {
        try{
            comentarioServicio.registrarComentario(comentarioDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Comentario Agregado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PutMapping(value = "/responder-comentario")
    public ResponseEntity<MensajeDTO<Object>> responderComentario(@Valid @RequestBody RespuestaDTO respuestaDTO) throws Exception {
        try{
            comentarioServicio.responderComentario(respuestaDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Comentario respuesto"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    //FIN SECCION DE  COMENTARIOS

}
