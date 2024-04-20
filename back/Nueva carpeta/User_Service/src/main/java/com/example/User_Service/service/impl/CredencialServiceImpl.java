package com.example.User_Service.service.impl;

import com.example.User_Service.entity.Credencial;
import com.example.User_Service.mapper.CredencialMapper;
import com.example.User_Service.repository.CredencialRepository;
import com.example.User_Service.service.CredencialService;
import com.mycompany.utilities.dto.CredencialDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CredencialServiceImpl implements CredencialService {

    private CredencialRepository credencialRepository;

    @Override
    public CredencialDto createCredencial(CredencialDto credencialDto) {
        Credencial credencial = CredencialMapper.mapToCredencial(credencialDto);
        Credencial saveCredencial = credencialRepository.save(credencial);
        return CredencialMapper.mapToCredencialDto(saveCredencial);
    }

}
