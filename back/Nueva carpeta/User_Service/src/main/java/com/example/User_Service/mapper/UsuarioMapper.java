package com.example.User_Service.mapper;

import com.example.User_Service.entity.Usuario;
import com.mycompany.utilities.dto.UsuarioDto;

public class UsuarioMapper {

    public static UsuarioDto mapToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId_usuario(),
                usuario.getNombres(),
                usuario.getApellido_paterno(),
                usuario.getApellido_materno(),
                usuario.getTelefono(),
                usuario.getFecha_nacimiento(),
                usuario.getGenero(),
                usuario.getTipo_usuario(),
                CredencialMapper.mapToCredencialDto(usuario.getCredencial()),
                DireccionMapper.mapToListDireccionDto(usuario.getDirecciones())
        );
    }

    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.getId_usuario(),
                usuarioDto.getNombres(),
                usuarioDto.getApellido_paterno(),
                usuarioDto.getApellido_materno(),
                usuarioDto.getTelefono(),
                usuarioDto.getFecha_nacimiento(),
                usuarioDto.getGenero(),
                usuarioDto.getTipo_usuario(),
                CredencialMapper.mapToCredencial(usuarioDto.getCredencialDto()),
                DireccionMapper.mapToListDireccion(usuarioDto.getDirecciones())
        );
    }
}
