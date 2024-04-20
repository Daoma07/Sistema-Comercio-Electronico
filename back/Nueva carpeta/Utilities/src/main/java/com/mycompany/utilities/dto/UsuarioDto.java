package com.mycompany.utilities.dto;

import com.mycompany.utilities.dto.generos.Genero;
import com.mycompany.utilities.dto.tipo_usuarios.TipoUsuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UsuarioDto implements Serializable {

    private Long id_usuario;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    private Date fecha_nacimiento;
    private Genero genero;
    private TipoUsuario tipo_usuario;
    private CredencialDto credencialDto;
    private List<DireccionDto> direcciones;

    public UsuarioDto() {
    }

    public UsuarioDto(String nombres, String apellido_paterno, String apellido_materno, String telefono, Date fecha_nacimiento, Genero genero, TipoUsuario tipo_usuario, CredencialDto credencialDto, List<DireccionDto> direcciones) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.tipo_usuario = tipo_usuario;
        this.credencialDto = credencialDto;
        this.direcciones = direcciones;
    }

    public UsuarioDto(Long id_usuario, String nombres, String apellido_paterno, String apellido_materno, String telefono, Date fecha_nacimiento, Genero genero, TipoUsuario tipo_usuario, CredencialDto credencialDto, List<DireccionDto> direcciones) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.tipo_usuario = tipo_usuario;
        this.credencialDto = credencialDto;
        this.direcciones = direcciones;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public CredencialDto getCredencialDto() {
        return credencialDto;
    }

    public void setCredencialDto(CredencialDto credencialDto) {
        this.credencialDto = credencialDto;
    }

    public List<DireccionDto> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionDto> direcciones) {
        this.direcciones = direcciones;
    }

}
