package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;


import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.MensajeDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.PublicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/publico")
@RequiredArgsConstructor
public class PublicoController {

    private final PublicoServicio publicoServicio;
    private final ComentarioServicio comentarioServicio;

    @PostMapping(value = "/registrar")
    public ResponseEntity<MensajeDTO<String>> registrarCliente(@Valid @RequestBody RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        try{
            publicoServicio.registroCliente(registroUsuarioDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Cliente registrado correctamente"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/listar-negocios-activos-aprobados")
    public ResponseEntity<MensajeDTO<Object>> listarNegociosActivosAprobados() throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, publicoServicio.listarNegociosActivosAprobados()));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }



    @GetMapping(value = "/listar-comentarios-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<Object>> listarComentariosNegocio(@PathVariable String idNegocio) throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, comentarioServicio.listarComentariosNegocio(idNegocio)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }


    @GetMapping(value = "/calificacion-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<Object>> CalificacionNegocio(@PathVariable String idNegocio) throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, comentarioServicio.calificacionNegocio(idNegocio)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }
}
