package com.example.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.Administrador;

@Mapper
public interface AdministradorMapper {
    AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);

    AdministradorDTO convert(Administrador admin);
}
