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
@Table(name = "producto_talla")
public class Producto_Talla {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto_talla;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    //Relaciones 
    @ManyToOne()
    @JoinColumn(name = "id_talla")
    private Talla talla;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Producto_Talla() {
    }

    public Producto_Talla(int cantidad, Talla talla, Producto producto) {
        this.cantidad = cantidad;
        this.talla = talla;
        this.producto = producto;
    }

    public Producto_Talla(Long id_producto_talla, int cantidad, Talla talla, Producto producto) {
        this.id_producto_talla = id_producto_talla;
        this.cantidad = cantidad;
        this.talla = talla;
        this.producto = producto;
    }

    public Long getId_producto_talla() {
        return id_producto_talla;
    }

    public void setId_producto_talla(Long id_producto_talla) {
        this.id_producto_talla = id_producto_talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
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
        hash = 97 * hash + Objects.hashCode(this.id_producto_talla);
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
        final Producto_Talla other = (Producto_Talla) obj;
        if (!Objects.equals(this.id_producto_talla, other.id_producto_talla)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto_Talla{" + "id_producto_talla=" + id_producto_talla + ", cantidad=" + cantidad + ", talla=" + talla + ", producto=" + producto + '}';
    }

}
