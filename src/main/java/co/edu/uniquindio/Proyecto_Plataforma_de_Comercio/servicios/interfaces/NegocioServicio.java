package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;

import java.util.List;
import java.util.Optional;

public interface NegocioServicio {

    DetalleNegocioDTO obtenerNegocioCodigo(String codigo) throws Exception;
    String crearNegocio(CrearNegocioDTO crearNegocioDTO) throws Exception;
    List<DetalleNegocioDTO> listarNegociosCliente(String idCliente) throws Exception;
    void actualizarNegocio(EditarNegocioDTO editarNegocioDTO) throws Exception;
    void eliminarNegocio(String idNegocio) throws Exception;
    void CambiarEstadoRegistro(CambioEstadoRegistroDTO cambioEstadoRegistroDTO) throws Exception;
    List<DetalleNegocioDTO> listarNegociosActivosAprobados() throws Exception;
    List<DetalleNegocioDTO> listarNegociosPendientes() throws Exception;
    List<DetalleNegocioDTO> listarNegocioNombreOTipo(NegocioNombreTipoDistanciaDTO negocioNombreTipoDistanciaDTO) throws Exception;
}