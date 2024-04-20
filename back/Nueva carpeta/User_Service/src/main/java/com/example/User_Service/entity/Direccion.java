package com.example.User_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direcciones")
public class Direccion {

    //Atributos
    @Id
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

}
