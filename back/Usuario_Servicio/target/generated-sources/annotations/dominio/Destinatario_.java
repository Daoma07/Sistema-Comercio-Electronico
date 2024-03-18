package dominio;

import dominio.Direccion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-17T17:20:53", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Destinatario.class)
public class Destinatario_ { 

    public static volatile SingularAttribute<Destinatario, String> apellido_paterno;
    public static volatile SingularAttribute<Destinatario, String> apellido_materno;
    public static volatile SingularAttribute<Destinatario, Direccion> direccion;
    public static volatile SingularAttribute<Destinatario, Long> id_destinatario;
    public static volatile SingularAttribute<Destinatario, String> telefono;
    public static volatile SingularAttribute<Destinatario, String> nombres;

}