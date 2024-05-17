package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.ActualizarCuentaDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.CambioPasswordDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroCuentaDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoCliente;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.CuentaRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.CuentaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaServicioImpl implements CuentaServicio {

    private final CuentaRepo cuentaRepo;
    private final ImagenesServicioImpl imagenesServicio;

    @Override
    public void crearCuenta(RegistroCuentaDTO registroCuentaDTO) throws Exception {

        Cuenta cuenta = new Cuenta();

        //verificamos que el email sea único
        if(existeEmail(registroCuentaDTO.email())){
            throw new Exception("El correo ya se encuentra registrado");
        }

        //verificamos que el nickname sea unico
        if(existeNickname(registroCuentaDTO.nickname())){
            throw new Exception("El nickname ya se encuentra en uso");
        }

        cuenta.setNickname(registroCuentaDTO.nickname());
        cuenta.setEmail(registroCuentaDTO.email());
        //
        cuenta.setEstadoCliente(EstadoCliente.ACTIVO);

        File uploadedFile = new File(registroCuentaDTO.fotoPerfil());
        Map cloudinaryResponse = imagenesServicio.subirImagenII(uploadedFile);
        String urlCloudinary = cloudinaryResponse.get("url").toString();
        cuenta.setFotoPerfil(urlCloudinary);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(registroCuentaDTO.password());
        cuenta.setPassword( passwordEncriptada );
        cuentaRepo.save(cuenta);

    }

    public void actualizarCuenta(ActualizarCuentaDTO actualizarCuentaDTO) throws Exception{
        Optional<Cuenta> cuentaOptional = cuentaRepo.findById(actualizarCuentaDTO.id());
        Cuenta cuenta = new Cuenta();

        if(cuentaOptional.isEmpty()){
            throw new Exception("La cuenta no existe");
        }
        else{

            cuenta = cuentaOptional.get();
            cuenta.setEmail(actualizarCuentaDTO.email());
            cuenta.setFotoPerfil(actualizarCuentaDTO.fotoPerfil());

            cuentaRepo.save(cuenta);
        }
    }

    @Override
    public void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception {

    }

    @Override
    public void inactivarCuenta(String idcuenta) throws Exception {

        Optional<Cuenta> optionalCuenta = cuentaRepo.findById(idcuenta);
        Cuenta cuenta = new Cuenta();

        if(optionalCuenta.isEmpty()){
            throw new Exception("Cuenta no existe");
        }
        cuenta = optionalCuenta.get();
        cuenta.setEstadoCliente(EstadoCliente.INACTIVO);

        cuentaRepo.save(cuenta);
    }

    public boolean existeEmail(String email){
        return cuentaRepo.findByEmail(email).isPresent();
    }

    public boolean existeNickname(String nickname){
        return cuentaRepo.findByNickname(nickname).isPresent();
    }

    public Cuenta obtenerCuentaPorEmail(String email) throws Exception{
        Optional<Cuenta> cuenta = cuentaRepo.findByEmail(email);

        if(cuenta.isEmpty()){
            throw new Exception("Cuenta no Existe");
        }
        else{
            return cuenta.get();
        }
    }

    public Cuenta obtenerCuentaPorId(String id) throws Exception{
        Optional<Cuenta> cuenta = cuentaRepo.findById(id);

        if(cuenta.isEmpty()){
            throw new Exception("Cuenta no Existe");
        }
        else{
            return cuenta.get();
        }
    }
}
