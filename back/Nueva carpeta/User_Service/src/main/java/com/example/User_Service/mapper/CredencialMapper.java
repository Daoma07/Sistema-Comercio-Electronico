package com.example.User_Service.mapper;

import com.example.User_Service.entity.Credencial;
import com.mycompany.utilities.dto.CredencialDto;

public class CredencialMapper {

    public static CredencialDto mapToCredencialDto(Credencial credencial) {
        return new CredencialDto(
                credencial.getId_credencial(),
                credencial.getCorreo(),
                credencial.getContrasenia()
        );
    }

    public static Credencial mapToCredencial(CredencialDto credencialDto) {
        return new Credencial(
                credencialDto.getId_credencial(),
                credencialDto.getCorreo(),
                credencialDto.getContrasenia()
        );
    }

}
