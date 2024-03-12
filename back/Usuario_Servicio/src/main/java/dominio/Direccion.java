package dominio;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_direccion;

    @Column(name = "calle", nullable = false, length = 150)
    private String calle;

    @Column(name = "numero", nullable = false, length = 150)
    private String numero;

    @Column(name = "colonia", nullable = false, length = 150)
    private String colonia;

    @Column(name = "ciudad", nullable = false, length = 150)
    private String ciudad;

    @Column(name = "estado", nullable = false, length = 150)
    private String estado;

    @Column(name = "codigo_postal", nullable = false, length = 150)
    private String codigo_postal;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String colonia, String ciudad, String estado, String codigo_postal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
    }

    public Direccion(String calle, String numero, String colonia, String ciudad, String estado, String codigo_postal, Usuario usuario) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
        this.usuario = usuario;
    }

    public Direccion(Long id_direccion, String calle, String numero, String colonia, String ciudad, String estado, String codigo_postal, Usuario usuario) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
        this.usuario = usuario;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id_direccion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        return Objects.equals(this.id_direccion, other.id_direccion);
    }

    @Override
    public String toString() {
        return "Direccion{" + "id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", codigo_postal=" + codigo_postal + '}';
    }

}
