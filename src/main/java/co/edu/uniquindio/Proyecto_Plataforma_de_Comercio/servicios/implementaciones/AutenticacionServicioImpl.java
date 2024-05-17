package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.EmailDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.InicioSesionDTO;
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

    @Override
    public TokenDTO iniciarSesionCliente(InicioSesionDTO loginDTO) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByEmail(loginDTO.email());

        if(cuentaOptional.isEmpty()){
            throw new Exception("Cuenta no existe");
        }

        Cuenta cuenta = cuentaOptional.get();
        Optional<Cliente> clienteOptional = clienteRepo.findByIdCuenta(cuenta.getId());

        if(clienteOptional.isEmpty()){
            throw new Exception("El correo no se encuentra registrado");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Cliente cliente = clienteOptional.get();

        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("rol", "CLIENTE");
        map.put("nombre", cliente.getNombre());
        map.put("id", cliente.getCodigo());

        return new TokenDTO(jwtUtils.generarToken(cuenta.getEmail(), map) );
    }

    @Override
    public TokenDTO iniciarSesionModerador(InicioSesionDTO loginDTO) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByEmail(loginDTO.email());

        if(cuentaOptional.isEmpty()){
            throw new Exception("Cuenta no existe");
        }

        Cuenta cuenta = cuentaOptional.get();
        Optional<Moderador> moderadorOptional = moderadorRepo.findByIdCuenta(cuenta.getId());

        if(moderadorOptional.isEmpty()){
            throw new Exception("El correo no se encuentra registrado");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Moderador moderador = moderadorOptional.get();

        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ) {
            throw new Exception("La contraseña es incorrecta");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("rol", "MODERADOR");
        map.put("nombre", moderador.getNombre());
        map.put("id", moderador.getCodigo());

        return new TokenDTO(jwtUtils.generarToken(cuenta.getEmail(), map) );
    }

    @Override
    public void recuparContrasenna(String email) throws Exception {
        String link;
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByEmail(email);

        link = "http://www.intermedia-col.com/";

        if(cuentaOptional.isEmpty()){
            throw new Exception("Cuenta no existe");
        }

        Cuenta cuenta = cuentaOptional.get();

        Map<String, Object> map = new HashMap<>();
        map.put("email", cuenta.getEmail());

        link += jwtUtils.generarToken(cuenta.getEmail(), map);

        emailServicio.enviarCorreo(new EmailDTO("Recuperar Contarseña",
                "aqui está tu link de recuperación de la contraseña <br> " + link, email));
    }
}