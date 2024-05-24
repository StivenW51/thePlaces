package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RecuperacionPasswordDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.RegistroCuentaDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;


public interface CuentaServicio {
    void crearCuenta(RegistroCuentaDTO registroCuentaDTO)throws Exception;
    void cambiarPassword(RecuperacionPasswordDTO recuperacionPasswordDTO)throws Exception;
    void inactivarCuenta(String idcuenta)throws Exception;
    boolean existeNickname(String nickName) throws Exception;
    boolean existeEmail(String email) throws Exception;
    Cuenta obtenerCuentaPorEmail(String email) throws Exception;
    public Cuenta obtenerCuentaPorId(String id) throws Exception;
}
