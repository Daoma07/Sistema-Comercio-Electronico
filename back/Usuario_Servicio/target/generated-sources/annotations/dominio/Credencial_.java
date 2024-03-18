package dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-17T17:20:53", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Credencial.class)
public class Credencial_ { 

    public static volatile SingularAttribute<Credencial, Long> id_credencial;
    public static volatile SingularAttribute<Credencial, String> correo;
    public static volatile SingularAttribute<Credencial, String> contrasenia;

}