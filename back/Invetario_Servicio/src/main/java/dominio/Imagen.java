package dominio;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_imagen;

    @Lob
    @Column(nullable = false)
    private byte[] contenido;

    //Relacion con Producto
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Imagen() {
    }

    public Imagen(byte[] contenido, Producto producto) {
        this.contenido = contenido;
        this.producto = producto;
    }

    public Imagen(Long id_imagen, byte[] contenido, Producto producto) {
        this.id_imagen = id_imagen;
        this.contenido = contenido;
        this.producto = producto;
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id_imagen);
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
        final Imagen other = (Imagen) obj;
        if (!Objects.equals(this.id_imagen, other.id_imagen)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id_imagen=" + id_imagen + ", contenido=" + contenido + ", producto=" + producto + '}';
    }

}
