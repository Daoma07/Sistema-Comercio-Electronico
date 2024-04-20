package dominio;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credenciales")
public class Credencial {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_credencial;

    @Column(name = "correo", nullable = false, unique = true, length = 300)
    private String correo;

    @Column(name = "contrasenia", nullable = false, length = 50)
    private String contrasenia;

    public Credencial() {
    }

    public Credencial(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Credencial(Long id_credencial, String correo, String contrasenia) {
        this.id_credencial = id_credencial;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Long getId_credencial() {
        return id_credencial;
    }

    public void setId_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean validarCredencial(Credencial credencial) {
        if (this.correo.equals(credencial.getCorreo()) && this.contrasenia.equals(this.getContrasenia())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id_credencial);
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Credencial other = (Credencial) obj;
        return Objects.equals(this.id_credencial, other.id_credencial);
    }

}
