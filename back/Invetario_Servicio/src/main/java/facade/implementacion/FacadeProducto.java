package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Producto;
import facade.interfaces.IFacadeProducto;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeProducto implements IFacadeProducto{
    
    private IFabricaDAO fabricaDAO;
    
    public FacadeProducto(){
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Producto crearProducto(Producto producto) throws PersistenceException {
        return fabricaDAO.crearProductoDAO().crearProducto(producto);
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        return fabricaDAO.crearProductoDAO().actualizarProducto(producto);
    }

    @Override
    public Producto consultarProductoID(Long id) {
        return fabricaDAO.crearProductoDAO().consultarProductoID(id);
    }

    @Override
    public boolean eliminarProducto(Producto producto) {
        return fabricaDAO.crearProductoDAO().eliminarProducto(producto);
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return fabricaDAO.crearProductoDAO().obtenerTodosProductos();
    }
    
}
