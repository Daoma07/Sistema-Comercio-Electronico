package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Producto_Talla;
import facade.interfaces.IFacadeProducto_Talla;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeProducto_Talla implements IFacadeProducto_Talla{
    
    private IFabricaDAO fabricaDAO;
    
    public FacadeProducto_Talla(){
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Producto_Talla crearProductoTalla(Producto_Talla producto_talla) throws PersistenceException {
        return fabricaDAO.crearProductoTallaDAO().crearProducto_Talla(producto_talla);
    }

    @Override
    public boolean actualizarProductoTalla(Producto_Talla producto_talla) {
        return fabricaDAO.crearProductoTallaDAO().actualizarProducto_Talla(producto_talla);
    }

    @Override
    public Producto_Talla consultarProductoTallaID(Long id) {
        return fabricaDAO.crearProductoTallaDAO().consultarProducto_TallaID(id);
    }

    @Override
    public boolean eliminarProductoTalla(Producto_Talla producto_talla) {
        return fabricaDAO.crearProductoTallaDAO().eliminarProducto_Talla(producto_talla);
    }

    @Override
    public List<Producto_Talla> obtenerTodosProductosTalla() {
        return fabricaDAO.crearProductoTallaDAO().obtenerTodosProducto_Talla();
    }
    
}
