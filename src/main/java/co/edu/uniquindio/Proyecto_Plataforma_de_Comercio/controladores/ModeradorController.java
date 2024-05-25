package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EstadoRegistroModeradorDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.MensajeDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.ModeradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/moderador")
@RequiredArgsConstructor
public class ModeradorController {

    private final ModeradorServicio moderadorServicio;

    @PostMapping(value = "/revisar-negocio")
    public ResponseEntity<MensajeDTO<Object>> revisarNegocio(@Valid @RequestBody DetalleRegistroModeradorDTO detalleRegistroModeradorDTO) throws Exception {
        try{
            moderadorServicio.revisarNegocio(detalleRegistroModeradorDTO );
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Registro exitoso"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @GetMapping(value = "/negocios-revisados/{idModerador}/{estadoRegistro}")
    public ResponseEntity<MensajeDTO<Object>> listarNegociosRevisadosModerador(@PathVariable String idModerador, @PathVariable String estadoRegistro) throws Exception {
        try{
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, moderadorServicio.listarNegociosRevisadosModerador(idModerador, estadoRegistro)));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }


}
