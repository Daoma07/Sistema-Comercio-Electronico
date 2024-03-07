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
@Table(name = "estilos")
public class Estilo {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estilo;

    @Column(name = "nombre", nullable = false, length = 150, unique = true)
    private String nombre;

    //Relacion con Producto
    @OneToMany(mappedBy = "estilo")
    private List<Producto> productos;

    public Estilo() {
    }

    public Estilo(Long id_estilo, String nombre) {
        this.id_estilo = id_estilo;
        this.nombre = nombre;
    }

    public Estilo(Long id_estilo, String nombre, List<Producto> productos) {
        this.id_estilo = id_estilo;
        this.nombre = nombre;
        this.productos = productos;
    }

    public Long getId_estilo() {
        return id_estilo;
    }

    public void setId_estilo(Long id_estilo) {
        this.id_estilo = id_estilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id_estilo);
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
        final Estilo other = (Estilo) obj;
        if (!Objects.equals(this.id_estilo, other.id_estilo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estilo{" + "id_estilo=" + id_estilo + ", nombre=" + nombre + ", productos=" + productos + '}';
    }

}
