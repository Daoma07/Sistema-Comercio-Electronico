package dominio;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tallas")
public class Talla {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_talla;

    @Column(name = "talla_us", nullable = false, length = 150, unique = true)
    private String talla_us;

    @Column(name = "talla_mx", nullable = false, length = 150, unique = true)
    private String talla_mx;

    //Relacion con producto
    @OneToMany(mappedBy = "talla")
    private List<Producto_Talla> productos;

    public Talla() {
    }

    public Talla(String talla_us, String talla_mx) {
        this.talla_us = talla_us;
        this.talla_mx = talla_mx;
    }

    public Talla(String talla_us, String talla_mx, List<Producto_Talla> productos) {
        this.talla_us = talla_us;
        this.talla_mx = talla_mx;
        this.productos = productos;
    }

    public Talla(Long id_talla, String talla_us, String talla_mx, List<Producto_Talla> productos) {
        this.id_talla = id_talla;
        this.talla_us = talla_us;
        this.talla_mx = talla_mx;
        this.productos = productos;
    }

    public Long getId_talla() {
        return id_talla;
    }

    public void setId_talla(Long id_talla) {
        this.id_talla = id_talla;
    }

    public String getTalla_us() {
        return talla_us;
    }

    public void setTalla_us(String talla_us) {
        this.talla_us = talla_us;
    }

    public String getTalla_mx() {
        return talla_mx;
    }

    public void setTalla_mx(String talla_mx) {
        this.talla_mx = talla_mx;
    }

    public List<Producto_Talla> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto_Talla> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id_talla);
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
        final Talla other = (Talla) obj;
        if (!Objects.equals(this.id_talla, other.id_talla)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Talla{" + "id_talla=" + id_talla + ", talla_us=" + talla_us + ", talla_mx=" + talla_mx + ", productos=" + productos + '}';
    }

}
