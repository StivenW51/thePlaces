package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/negocio")
@RequiredArgsConstructor
public class NegocioController {

    private final NegocioServicio negocioServicio;

    @PostMapping(value = "/crear")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody CrearNegocioDTO crearNegocioDTO) throws Exception{
        try{
            negocioServicio.crearNegocio(crearNegocioDTO);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, "Negocio registrado correctamente"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<MensajeDTO<String>> actualizarNegocio(@Valid @RequestBody EditarNegocioDTO editarNegocioDTO) throws Exception{
        try{
            negocioServicio.actualizarNegocio(editarNegocioDTO);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, "Negocio actualizado correctamente"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/eliminar/{idNegocio}")
    public ResponseEntity<MensajeDTO<Object>> eliminarNegocio(@PathVariable String idNegocio) throws Exception{
        try{
            negocioServicio.eliminarNegocio(idNegocio);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Negocio Eliminado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/obtener/{codigo}")
    public ResponseEntity<MensajeDTO<Object>> obtenerNegocioCodigo(@PathVariable String codigo) throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, negocioServicio.obtenerNegocioCodigo(codigo)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/listarNegociosCliente/{idCliente}")
    public ResponseEntity<MensajeDTO<Object>> listarNegociosCliente(@PathVariable String idCliente) throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, negocioServicio.listarNegociosCliente(idCliente)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/listarNegociosPendientes")
    public ResponseEntity<MensajeDTO<Object>> listarNegociosPendientes() throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, negocioServicio.listarNegociosPendientes()));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PutMapping(value = "/cambiar-estado-registro")
    public ResponseEntity<MensajeDTO<String>> CambiarEstadoRegistro(@Valid @RequestBody CambioEstadoRegistroDTO cambioEstadoRegistroDTO) throws Exception{
        try{
            negocioServicio.CambiarEstadoRegistro(cambioEstadoRegistroDTO);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, "Estado Cambiado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }


    @GetMapping(value = "/listar-negocios-nombre-tipo")
    public ResponseEntity<MensajeDTO<Object>> listarNegocioNombreOTipo(@Valid @RequestBody NegocioNombreTipoDistanciaDTO negocioNombreTipoDistanciaDTO) throws Exception{
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, negocioServicio.listarNegocioNombreOTipo(negocioNombreTipoDistanciaDTO)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }


}
