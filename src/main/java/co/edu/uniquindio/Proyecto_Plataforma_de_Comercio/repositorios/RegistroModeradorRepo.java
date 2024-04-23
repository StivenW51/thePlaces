package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.RegistroModerador;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroModeradorRepo extends MongoRepository<RegistroModerador, String> {
    Optional<List<RegistroModerador>> findByIdModeradorAndEstadoRegistro (String idModerador, EstadoRegistro estadoRegistro);
}
