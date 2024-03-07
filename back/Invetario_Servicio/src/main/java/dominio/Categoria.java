package dominio;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(name = "nombre", nullable = false, length = 150, unique = true)
    private String nombre;

    //Relaciones
    @OneToMany(mappedBy = "categoria_padre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias_hijas;

    //Recursividad
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoria_padre;

    //Relacion con Producto
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(String nombre, List<Categoria> categorias_hijas, Categoria categoria_padre, List<Producto> productos) {
        this.nombre = nombre;
        this.categorias_hijas = categorias_hijas;
        this.categoria_padre = categoria_padre;
        this.productos = productos;
    }

    public Categoria(Long id_categoria, String nombre, List<Categoria> categorias_hijas, Categoria categoria_padre) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.categorias_hijas = categorias_hijas;
        this.categoria_padre = categoria_padre;
    }

    public Categoria(Long id_categoria, String nombre, List<Categoria> categorias_hijas, Categoria categoria_padre, List<Producto> productos) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.categorias_hijas = categorias_hijas;
        this.categoria_padre = categoria_padre;
        this.productos = productos;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias_hijas() {
        return categorias_hijas;
    }

    public void setCategorias_hijas(List<Categoria> categorias_hijas) {
        this.categorias_hijas = categorias_hijas;
    }

    public Categoria getCategoria_padre() {
        return categoria_padre;
    }

    public void setCategoria_padre(Categoria categoria_padre) {
        this.categoria_padre = categoria_padre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id_categoria);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id_categoria, other.id_categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", nombre=" + nombre + ", categorias_hijas=" + categorias_hijas + ", categoria_padre=" + categoria_padre + ", productos=" + productos + '}';
    }

}
