package facade.implementacion;

import dao.fabrica.FabricaDAO;
import dao.fabrica.IFabricaDAO;
import dominio.Estilo;
import facade.interfaces.IFacadeEstilo;
import java.util.List;
import javax.persistence.PersistenceException;

public class FacadeEstilo implements IFacadeEstilo{
    
    private IFabricaDAO fabricaDAO;
    
    public FacadeEstilo(){
        this.fabricaDAO = new FabricaDAO();
    }

    @Override
    public Estilo crearEstilo(Estilo estilo) throws PersistenceException {
        return fabricaDAO.crearEstiloDAO().crearEstilo(estilo);
    }

    @Override
    public boolean actualizarEstilo(Estilo estilo) {
        return fabricaDAO.crearEstiloDAO().actualizarEstilo(estilo);
    }

    @Override
    public Estilo consultarEstiloID(Long id) {
        return fabricaDAO.crearEstiloDAO().consultarEstiloID(id);
    }

    @Override
    public boolean eliminarEstilo(Estilo estilo) {
        return fabricaDAO.crearEstiloDAO().eliminarEstilo(estilo);
    }

    @Override
    public List<Estilo> obtenerTodosEstilos() {
        return fabricaDAO.crearEstiloDAO().obtenerTodosEstilos();
    }
    
}
