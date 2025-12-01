package basedd.ejercicio1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoAnuncio extends JpaRepository<Anuncio, Long>{

//aquí se guardan todos los métodos para manejar los datos extendiendo de JpaRepository

}
