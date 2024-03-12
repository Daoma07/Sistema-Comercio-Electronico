package facade.implementacion;

import dao.fabrica.IFabricaDAO;
import dao.inerfaces.IDireccionDAO;
import dominio.Direccion;
import facade.interfaces.IFacadeDireccion;
import java.util.List;

public class FacadeDireccion implements IFacadeDireccion {

    private IDireccionDAO direccionDAO;

    public FacadeDireccion(IFabricaDAO fabricaDAO) {
        this.direccionDAO = fabricaDAO.crearDireccionDAO();
    }

    @Override
    public Direccion crearDireccion(Direccion direccion) {
        return direccionDAO.crearDireccion(direccion);
    }

    @Override
    public boolean actualizarDireccion(Direccion direccion) {
        return direccionDAO.actualizarDireccion(direccion);
    }

    @Override
    public Direccion consultarDireccionID(Long id) {
        return direccionDAO.consultarDireccionID(id);
    }

    @Override
    public boolean eliminarDireccion(Direccion direccion) {
        return direccionDAO.eliminarDireccion(direccion);
    }

    @Override
    public List<Direccion> obtenerTodosDestinatario() {
        return direccionDAO.obtenerTodosDestinatario();
    }

}
