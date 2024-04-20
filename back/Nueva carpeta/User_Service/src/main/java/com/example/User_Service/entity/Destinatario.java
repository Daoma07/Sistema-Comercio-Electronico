package com.example.User_Service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "destinatarios")
public class Destinatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_destinatario;

    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 150)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false, length = 150)
    private String apellido_materno;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    //Relaciones
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

}
