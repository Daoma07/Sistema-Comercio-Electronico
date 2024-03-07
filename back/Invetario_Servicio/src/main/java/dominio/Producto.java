package dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @Column(name = "nombre", nullable = false, length = 150, unique = true)
    private String nombre;

    @Column(name = "descrpcion", nullable = false, length = 600)
    private String descrpcion;

    @Column(name = "marca", nullable = false, length = 150)
    private String marca;

    @Column(name = "material", nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialEnum material;

    @Column(name = "color", nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column(name = "codigo", nullable = false, length = 150, unique = true)
    private String codigo;

    @Column(name = "precio", nullable = false)
    private float precio;

    //Relaciones
    //Relacion con categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    //Relacion con imagen
    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    //Relacion con estilo
    @ManyToOne
    @JoinColumn(name = "id_estilo")
    private Estilo estilo;

    //Relacion con talla
    @OneToMany(mappedBy = "producto")
    private List<Producto_Talla> tallas;

    //Relacion con carrito
    @OneToMany(mappedBy = "producto")
    private List<Carrito> carritos;

    public Producto() {
    }

    public Producto(String nombre, String descrpcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, Categoria categoria, List<Imagen> imagenes, Estilo estilo, List<Producto_Talla> tallas) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.imagenes = imagenes;
        this.estilo = estilo;
        this.tallas = tallas;
    }

    public Producto(String nombre, String descrpcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, Categoria categoria, List<Imagen> imagenes, Estilo estilo, List<Producto_Talla> tallas, List<Carrito> carritos) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.imagenes = imagenes;
        this.estilo = estilo;
        this.tallas = tallas;
        this.carritos = carritos;
    }

    public Producto(Long id_producto, String nombre, String descrpcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, Categoria categoria, List<Imagen> imagenes, Estilo estilo, List<Producto_Talla> tallas, List<Carrito> carritos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.imagenes = imagenes;
        this.estilo = estilo;
        this.tallas = tallas;
        this.carritos = carritos;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public MaterialEnum getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public List<Producto_Talla> getTallas() {
        return tallas;
    }

    public void setTallas(List<Producto_Talla> tallas) {
        this.tallas = tallas;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", descrpcion=" + descrpcion + ", marca=" + marca + ", material=" + material + ", color=" + color + ", codigo=" + codigo + ", precio=" + precio + ", categoria=" + categoria + ", imagenes=" + imagenes + ", estilo=" + estilo + ", tallas=" + tallas + ", carritos=" + carritos + '}';
    }

}
