package com.example.User_Service.entity;

import com.mycompany.utilities.dto.generos.Genero;
import com.mycompany.utilities.dto.tipo_usuarios.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 150)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false, length = 150)
    private String apellido_materno;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipo_usuario;

    //Relaciones
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "credencial_id")
    private Credencial credencial;

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.ALL})
    private List<Direccion> direcciones;

}
