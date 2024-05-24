package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EmailDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RecuperarDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.TokenDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Moderador;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ClienteRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.CuentaRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.ModeradorRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final ClienteRepo clienteRepo;
    private final ModeradorRepo moderadorRepo;
    private final CuentaRepo cuentaRepo;
    private final JWTUtils jwtUtils;
    private final EmailServicioImpl emailServicio;


    public TokenDTO IniciarSesion(InicioSesionDTO loginDTO) throws Exception{
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByEmail(loginDTO.email());
        Map<String, Object> map = new HashMap<>();

        if(cuentaOptional.isEmpty()){
            throw new Exception("Cuenta no existe");
        }

        Cuenta cuenta = cuentaOptional.get();
        Optional<Cliente> clienteOptional = clienteRepo.findByIdCuenta(cuenta.getId());
        Optional<Moderador> moderadorOptional = moderadorRepo.findByIdCuenta(cuenta.getId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }

        if(clienteOptional.isEmpty()){
            if(moderadorOptional.isEmpty()){
                throw new Exception("El correo no se encuentra registrado");
            }
            else{
                Moderador moderador = moderadorOptional.get();

                map.put("rol", "MODERADOR");
                map.put("nombre", moderador.getNombre());
                map.put("id", moderador.getCodigo());
            }
        }
        else {
            Cliente cliente = clienteOptional.get();

            map.put("rol", "CLIENTE");
            map.put("nombre", cliente.getNombre());
            map.put("id", cliente.getCodigo());
        }

        return new TokenDTO(jwtUtils.generarToken(cuenta.getEmail(), map) );
    }

    @Override
    public void recuparContrasenna(RecuperarDTO recuperarDTO) throws Exception {
        String link;
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByEmail(recuperarDTO.email());

        link = recuperarDTO.url();

        if(cuentaOptional.isEmpty()){
            throw new Exception("Cuenta no existe");
        }

        Cuenta cuenta = cuentaOptional.get();

        Map<String, Object> map = new HashMap<>();
        map.put("email", cuenta.getEmail());

        link += jwtUtils.generarToken(cuenta.getEmail(), map);

        emailServicio.enviarCorreo(new EmailDTO("Recuperar Contarseña",
                "aqui está tu link de recuperación de la contraseña <br> "
                        + link, recuperarDTO.email()));
    }
}