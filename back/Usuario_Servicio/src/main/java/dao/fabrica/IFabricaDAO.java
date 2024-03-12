package dao.fabrica;

import dao.inerfaces.ICredencialDAO;
import dao.inerfaces.IDestinatarioDAO;
import dao.inerfaces.IDireccionDAO;
import dao.inerfaces.IUsuarioDAO;

public interface IFabricaDAO {

    ICredencialDAO crearCredencialDAO();

    IDestinatarioDAO crearDestinatarioDAO();

    IDireccionDAO crearDireccionDAO();

    IUsuarioDAO crearUsuarioDAO();
}
