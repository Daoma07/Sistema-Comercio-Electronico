package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Imagen;
import facade.interfaces.IFacadeImagen;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeImagen implements IFacadeImagen{
    
    private IFabricaDAO fabricaDAO;
    
    public FacadeImagen(){
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Imagen crearImagen(Imagen imagen) throws PersistenceException {
        return fabricaDAO.crearImagenDAO().crearImagen(imagen);
    }

    @Override
    public boolean actualizarImagen(Imagen imagen) {
        return fabricaDAO.crearImagenDAO().actualizarImagen(imagen);
    }

    @Override
    public Imagen consultarImagenID(Long id) {
        return fabricaDAO.crearImagenDAO().consultarImagenID(id);
    }

    @Override
    public boolean eliminarImagen(Imagen imagen) {
        return fabricaDAO.crearImagenDAO().eliminarImagen(imagen);
    }

    @Override
    public List<Imagen> obtenerTodasImagens() {
        return fabricaDAO.crearImagenDAO().obtenerTodasImagen();
    }
    
}
