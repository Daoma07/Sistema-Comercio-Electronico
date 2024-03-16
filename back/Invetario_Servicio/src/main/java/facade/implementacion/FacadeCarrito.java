package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Carrito;
import facade.interfaces.IFacadeCarrito;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeCarrito implements IFacadeCarrito{
    
    private IFabricaDAO fabricaDAO;
    
    public FacadeCarrito(){
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Carrito crearCarrito(Carrito carrito) throws PersistenceException {
        return fabricaDAO.crearCarritoDAO().crearCarrito(carrito);
    }

    @Override
    public boolean actualizarCarrito(Carrito carrito) {
        return fabricaDAO.crearCarritoDAO().actualizarCarrito(carrito);
    }

    @Override
    public Carrito consultarCarritoID(Long id) {
        return fabricaDAO.crearCarritoDAO().consultarCarritoID(id);
    }

    @Override
    public boolean eliminarCarrito(Carrito carrito) {
        return fabricaDAO.crearCarritoDAO().eliminarCarrito(carrito);
    }

    @Override
    public List<Carrito> obtenerTodosCarritos() {
        return fabricaDAO.crearCarritoDAO().obtenerTodosCarrito();
    }
}
