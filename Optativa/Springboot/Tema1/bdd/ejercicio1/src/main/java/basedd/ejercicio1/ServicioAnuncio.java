package basedd.ejercicio1;

import java.util.List;

public interface ServicioAnuncio {
public List<Anuncio> listarAnuncios();
public void insertarAnuncio(Anuncio anuncio);
public void borrarAnuncio(Long id);
public void obtenerAnuncio(Long id);
}
