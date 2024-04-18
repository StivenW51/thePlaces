package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.controladores;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.CrearNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.MensajeDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class NegocioControlador {

    private final NegocioServicio negocioServicio;

    @PostMapping("/crear-negocio")
    public ResponseEntity<MensajeDTO<String>> crearNegocio(@Valid @RequestBody
                                                           CrearNegocioDTO crearNegocioDTO) throws Exception{
        negocioServicio.crearNegocio(crearNegocioDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Negocio registrado correctamente")
        );
    }

    @GetMapping("/obtener-negocio/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleNegocioDTO>> obtenerNegocio(@PathVariable String
                                                                        codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,
                negocioServicio.obtenerNegocio(codigo)));
    }



}
