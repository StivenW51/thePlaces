package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.CuentaServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AutenticacionServicio autenticacionServicio;
    private final CuentaServicio cuentaServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<Object>> login(@Valid @RequestBody InicioSesionDTO loginDTO) throws Exception {

        try{
            TokenDTO tokenDTO = autenticacionServicio.IniciarSesion(loginDTO);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PostMapping("/recuperar-contrasenna")
    public ResponseEntity<MensajeDTO<Object>> recuperarContrasenna(@Valid @RequestBody RecuperarDTO recuperarDTO) throws Exception {
        try{
            autenticacionServicio.recuparContrasenna(recuperarDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Link enviado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }

    @PostMapping(value = "/cambiar-password")
    public ResponseEntity<MensajeDTO<Object>> cambiarPassword(@Valid @RequestBody RecuperacionPasswordDTO recuperacionPasswordDTO) throws Exception {
        try{
            cuentaServicio.cambiarPassword(recuperacionPasswordDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Cambio de contraseña exitoso"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }
}
