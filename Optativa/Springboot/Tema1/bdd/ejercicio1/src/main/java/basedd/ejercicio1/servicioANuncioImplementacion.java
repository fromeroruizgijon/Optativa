package basedd.ejercicio1;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class servicioANuncioImplementacion implements ServicioAnuncio{
    @Autowired
private repoAnuncio repo;

    @Override
    public List<Anuncio> listarAnuncios() {
        return repo.findAll();
    }

    @Override
    public void insertarAnuncio(Anuncio anuncio) {
        repo.save(anuncio);
    }

    @Override
    public void borrarAnuncio(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void obtenerAnuncio(Long id) {
        repo.findById(id);
    }

}
