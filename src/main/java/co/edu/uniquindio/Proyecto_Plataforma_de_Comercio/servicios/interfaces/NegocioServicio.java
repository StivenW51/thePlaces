package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;

import java.util.List;

public interface NegocioServicio {

    DetalleNegocioDTO obtenerNegocioCodigo(String codigo) throws Exception;
    String crearNegocio(CrearNegocioDTO crearNegocioDTO) throws Exception;
    List<DetalleNegocioDTO> listarNegociosCliente(String idCliente) throws Exception;
    void actualizarNegocio(EditarNegocioDTO editarNegocioDTO) throws Exception;
    void eliminarNegocio(String idNegocio) throws Exception;
    void CambiarEstadoRegistro(CambioEstadoRegistroDTO cambioEstadoRegistroDTO) throws Exception;
    List<DetalleNegocioDTO> listarNegociosActivos() throws Exception;
    List<DetalleNegocioDTO> listarNegociosAprobadosModerador(String idModerador) throws Exception;
    List<DetalleNegocioDTO> listarNegociosRechazadosModerador(String idModerador) throws Exception;
    List<DetalleNegocioDTO> listarNegociosPendientes() throws Exception;

}