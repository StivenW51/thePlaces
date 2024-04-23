package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    List<Negocio> findAll();
    Optional<Negocio> findByCodigo (String codigo);
    List<Negocio> findByTipoNegocio(TipoNegocio tipoNegocio);
    Optional<List<Negocio>> findByEstadoRegistro(EstadoRegistro estadoRegistro);
    Optional<List<Negocio>> findByEstadoNegocio(EstadoNegocio estadoNegocio);
    Optional<List<Negocio>> findByEstadoNegocioAndEstadoRegistro(EstadoNegocio estadoNegocio, EstadoRegistro estadoRegistro);
    Optional<List<Negocio>> findByCodigoCliente(String codigoCliente);
    Optional<List<Negocio>> findByEstadoRegistroAndIdModerador(EstadoRegistro estadoRegistro, String idModerador);
    Optional<List<Negocio>> findByNombreIsLikeOrTipoNegocioIsLike(String nombre, String tipoNegocio);
}
