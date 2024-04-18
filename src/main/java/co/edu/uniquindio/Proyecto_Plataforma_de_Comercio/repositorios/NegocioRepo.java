package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.DetalleNegocioDTO;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@Repository
public interface NegocioRepo extends MongoRepository<Negocio, String> {
    List<Negocio> findAll();
    Optional<Negocio> findByCodigo (String codigo);
    List<Negocio> findByTipoNegocio(TipoNegocio tipoNegocio);
    List<Negocio> findByEstadoRegistro(EstadoRegistro estadoRegistro);
    List<Negocio> findByEstadoNegocio(EstadoNegocio estadoNegocio);
    Optional<Negocio> findByCodigoCliente(String codigoCliente);
}
