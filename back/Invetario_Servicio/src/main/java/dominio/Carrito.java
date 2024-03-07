/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author HP
 */
@Entity
@Table(name = "carritos")
public class Carrito {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    @Column(name = "importe", nullable = false)
    private float importe;

    @Column(name = "precio_unidad", nullable = false)
    private float precio_unidad;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "id_usuario", nullable = false)
    private Long id_usuario;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Carrito() {
    }

    public Carrito(float importe, float precio_unidad, int cantidad, Long id_usuario, Producto producto) {
        this.importe = importe;
        this.precio_unidad = precio_unidad;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.producto = producto;
    }

    public Carrito(Long id_carrito, float importe, float precio_unidad, int cantidad, Long id_usuario, Producto producto) {
        this.id_carrito = id_carrito;
        this.importe = importe;
        this.precio_unidad = precio_unidad;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.producto = producto;
    }

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(float precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_carrito);
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
        final Carrito other = (Carrito) obj;
        if (!Objects.equals(this.id_carrito, other.id_carrito)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrito{" + "id_carrito=" + id_carrito + ", importe=" + importe + ", precio_unidad=" + precio_unidad + ", cantidad=" + cantidad + ", id_usuario=" + id_usuario + ", producto=" + producto + '}';
    }

}
