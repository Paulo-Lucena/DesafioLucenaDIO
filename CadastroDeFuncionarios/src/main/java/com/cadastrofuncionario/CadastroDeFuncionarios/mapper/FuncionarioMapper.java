package com.cadastrofuncionario.CadastroDeFuncionarios.mapper;


import com.cadastrofuncionario.CadastroDeFuncionarios.dto.request.FuncionarioDTO;
import com.cadastrofuncionario.CadastroDeFuncionarios.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionarioMapper {

    FuncionarioMapper INSTANTCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario toModel(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO toDTO(Funcionario funcionario);

}
