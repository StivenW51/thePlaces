package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EmailDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.MensajeDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.EmailServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailServicio emailServicio;

    @PostMapping(value = "/enviar")
    public ResponseEntity<MensajeDTO<String>> enviarEmail(@Valid @RequestBody EmailDTO emailDTO) throws Exception {
        try{
            emailServicio.enviarCorreo(emailDTO);
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(false, "email enviado"));
        }
        catch (Exception ex) {
            return ResponseEntity.ok().body(
                    new MensajeDTO<>(true, ex.getMessage()));
        }
    }
}
