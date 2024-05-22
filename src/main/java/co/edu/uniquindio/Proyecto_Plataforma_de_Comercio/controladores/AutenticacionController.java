package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.MensajeDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.TokenDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.AutenticacionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AutenticacionServicio autenticacionServicio;
//    @PostMapping("/login-cliente")
//    public ResponseEntity<MensajeDTO<Object>> iniciarSesionCliente(@Valid @RequestBody InicioSesionDTO loginDTO) throws Exception {
//
//        try{
//            TokenDTO tokenDTO = autenticacionServicio.iniciarSesionCliente(loginDTO);
//            return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
//        }
//        catch (Exception ex) {
//            return ResponseEntity.ok().body(
//                    new MensajeDTO<>(true, ex.getMessage()));
//        }
//    }
//
//    @PostMapping("/login-moderador")
//    public ResponseEntity<MensajeDTO<Object>> iniciarSesionModerador(@Valid @RequestBody InicioSesionDTO loginDTO) throws Exception {
//
//        try{
//            TokenDTO tokenDTO = autenticacionServicio.iniciarSesionModerador(loginDTO);
//            return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
//        }
//        catch (Exception ex) {
//            return ResponseEntity.ok().body(
//                    new MensajeDTO<>(true, ex.getMessage()));
//        }
//    }


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

    @PostMapping("/recuperar-contrasenna/{email}")
    public ResponseEntity<MensajeDTO<Object>> recuperarContrasenna(@PathVariable String email) throws Exception {
        try{
            autenticacionServicio.recuparContrasenna(email);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "Link enviado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }
}
