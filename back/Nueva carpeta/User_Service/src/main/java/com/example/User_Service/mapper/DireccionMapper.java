package com.example.User_Service.mapper;

import com.example.User_Service.entity.Direccion;
import com.mycompany.utilities.dto.DireccionDto;
import java.util.ArrayList;
import java.util.List;

public class DireccionMapper {

    public static DireccionDto mapToDireccionDto(Direccion direccion) {
        return new DireccionDto(
                direccion.getId_direccion(),
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getColonia(),
                direccion.getCiudad(),
                direccion.getEstado(),
                direccion.getCodigo_postal(),
                UsuarioMapper.mapToUsuarioDto(direccion.getUsuario())
        );
    }

    public static Direccion mapToDireccion(DireccionDto direccionDto) {
        return new Direccion(
                direccionDto.getId_direccion(),
                direccionDto.getCalle(),
                direccionDto.getNumero(),
                direccionDto.getColonia(),
                direccionDto.getCiudad(),
                direccionDto.getEstado(),
                direccionDto.getCodigo_postal(),
                UsuarioMapper.mapToUsuario(direccionDto.getUsuarioDto())
        );
    }

    public static List<DireccionDto> mapToListDireccionDto(List<Direccion> direcciones) {

        List<DireccionDto> direccionesDto = new ArrayList<>();

        for (Direccion direccion : direcciones) {
            direccionesDto.add(new DireccionDto(
                    direccion.getId_direccion(),
                    direccion.getCalle(),
                    direccion.getNumero(),
                    direccion.getColonia(),
                    direccion.getCiudad(),
                    direccion.getEstado(),
                    direccion.getCodigo_postal(),
                    UsuarioMapper.mapToUsuarioDto(direccion.getUsuario())
            ));
        }

        return direccionesDto;
    }

    public static List<Direccion> mapToListDireccion(List<DireccionDto> direccionesDto) {

        List<Direccion> direcciones = new ArrayList<>();

        for (DireccionDto direccionDto : direccionesDto) {
            direcciones.add(new Direccion(
                    direccionDto.getId_direccion(),
                    direccionDto.getCalle(),
                    direccionDto.getNumero(),
                    direccionDto.getColonia(),
                    direccionDto.getCiudad(),
                    direccionDto.getEstado(),
                    direccionDto.getCodigo_postal(),
                    UsuarioMapper.mapToUsuario(direccionDto.getUsuarioDto())
            ));
        }

        return direcciones;
    }

}
