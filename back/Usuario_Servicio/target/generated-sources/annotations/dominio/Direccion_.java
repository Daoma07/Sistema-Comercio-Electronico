package dominio;

import dominio.Usuario;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-13T22:35:27", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile SingularAttribute<Direccion, String> estado;
    public static volatile SingularAttribute<Direccion, String> codigo_postal;
    public static volatile SingularAttribute<Direccion, String> numero;
    public static volatile SingularAttribute<Direccion, String> ciudad;
    public static volatile SingularAttribute<Direccion, Long> id_direccion;
    public static volatile SingularAttribute<Direccion, String> calle;
    public static volatile SingularAttribute<Direccion, Usuario> usuario;
    public static volatile SingularAttribute<Direccion, String> colonia;

}