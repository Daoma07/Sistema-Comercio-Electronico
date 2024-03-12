package dominio;

import dominio.Credencial;
import dominio.Direccion;
import dominio.Genero;
import dominio.TipoUsuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-11T19:29:35", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Credencial> credencial;
    public static volatile SingularAttribute<Usuario, Long> id_usuario;
    public static volatile SingularAttribute<Usuario, Genero> genero;
    public static volatile ListAttribute<Usuario, Direccion> direcciones;
    public static volatile SingularAttribute<Usuario, String> apellido_paterno;
    public static volatile SingularAttribute<Usuario, String> apellido_materno;
    public static volatile SingularAttribute<Usuario, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, TipoUsuario> tipo_usuario;
    public static volatile SingularAttribute<Usuario, String> nombres;

}