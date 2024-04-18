package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.ActualizacionUsuarioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.CambioPasswordDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroCuentaDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface CuentaServicio {
    void crearCuenta(RegistroCuentaDTO registroCuentaDTO)throws Exception;
    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO)throws Exception;
    void inactivarCuenta(String idcuenta)throws Exception;
    boolean existeNickname(String nickName) throws Exception;
    boolean existeEmail(String email) throws Exception;
    Cuenta obtenerCuentaPorEmail(String email) throws Exception;
    public Cuenta obtenerCuentaPorId(String id) throws Exception;
}
