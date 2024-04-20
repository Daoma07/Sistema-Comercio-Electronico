package com.example.User_Service.service.impl;

import com.example.User_Service.entity.Usuario;
import com.example.User_Service.mapper.UsuarioMapper;
import com.example.User_Service.repository.UsuarioRepository;
import com.example.User_Service.service.UsuarioService;
import com.mycompany.utilities.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDto);
        Usuario saveUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(saveUsuario);
    }

}
