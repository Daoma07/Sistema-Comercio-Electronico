package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Categoria;
import facade.interfaces.IFacadeCategoria;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeCategoria implements IFacadeCategoria{
    
    private IFabricaDAO fabricaDAO;

    public FacadeCategoria() {
        this.fabricaDAO = new FabricaDAO();
    }
    
    @Override
    public Categoria crearCategoria(Categoria categoria) throws PersistenceException {
        return fabricaDAO.crearCategoriaDAO().crearCategoria(categoria);
    }

    @Override
    public boolean actualizarCategoria(Categoria categoria) {
        return fabricaDAO.crearCategoriaDAO().actualizarCategoria(categoria);
    }

    @Override
    public Categoria consultarCategoriaID(Long id) {
        return fabricaDAO.crearCategoriaDAO().consultarCategoriaID(id);
    }

    @Override
    public boolean eliminarCategoria(Categoria categoria) {
        return fabricaDAO.crearCategoriaDAO().eliminarCategoria(categoria);
    }

    @Override
    public List<Categoria> obtenerTodasCategorias() {
        return fabricaDAO.crearCategoriaDAO().obtenerTodasCategorias();
    }
}
