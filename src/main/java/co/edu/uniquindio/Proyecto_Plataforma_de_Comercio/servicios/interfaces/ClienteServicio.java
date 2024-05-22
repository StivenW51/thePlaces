package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente;

import java.util.List;

public interface ClienteServicio {


    void actualizarPerfil(ActualizacionUsuarioDTO actualizacionUsuarioDTO)throws Exception;
    void eliminarPerfil(String idCliente)throws Exception;
    void iniciarSesion(InicioSesionDTO inicioSesionDTO)throws Exception;
    void enviarLinkRecuparcion(String email)throws Exception;
    void recuperarPassword(RecuperacionPasswordDTO recuperacionPasswordDTO)throws Exception;
    DetalleClienteDTO obtenerCliente(String idCliente)throws Exception;
    List<ItemClienteDTO> listarClientes();
    List<DetalleNegocioDTO> listarFavoritos(String idCliente) throws Exception;
    void AgregarFavorito(FavoritoDTO favoritoDTO) throws Exception;
    void QuitarFavorito(FavoritoDTO favoritoDTO) throws Exception;


}
