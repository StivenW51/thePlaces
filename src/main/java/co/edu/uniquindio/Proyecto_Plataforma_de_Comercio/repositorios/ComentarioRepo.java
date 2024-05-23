package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentarioRepo extends MongoRepository<Comentario, String> {
    Optional<Comentario> findById(String id);
    Optional<List<Comentario>> findByCodigoNegocio(String idNegocio);
}
