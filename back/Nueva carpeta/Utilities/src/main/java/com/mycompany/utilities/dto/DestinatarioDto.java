package com.mycompany.utilities.dto;

import java.io.Serializable;

public class DestinatarioDto implements Serializable {

    private Long id_destinatario;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    private DireccionDto direccion;

    public DestinatarioDto() {
    }

    public DestinatarioDto(String nombres, String apellido_paterno, String apellido_materno, String telefono, DireccionDto direccion) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public DestinatarioDto(Long id_destinatario, String nombres, String apellido_paterno, String apellido_materno, String telefono, DireccionDto direccion) {
        this.id_destinatario = id_destinatario;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Long getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(Long id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

}
