package com.mycompany.utilities.dto;

import java.io.Serializable;

public class CredencialDto implements Serializable {

    private Long id_credencial;
    private String correo;
    private String contrasenia;

    public CredencialDto() {
    }

    public CredencialDto(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public CredencialDto(Long id_credencial, String correo, String contrasenia) {
        this.id_credencial = id_credencial;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Long getId_credencial() {
        return id_credencial;
    }

    public void setId_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
