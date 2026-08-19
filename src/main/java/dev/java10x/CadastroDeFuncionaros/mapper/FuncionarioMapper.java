package dev.java10x.CadastroDeFuncionaros.mapper;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();

        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setName(funcionarioDTO.getName());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setImgUrl(funcionarioDTO.getImgUrl());
        funcionarioModel.setDepartamentos(funcionarioDTO.getDepartamentos());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel){

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setName(funcionarioModel.getName());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setImgUrl(funcionarioModel.getImgUrl());
        funcionarioDTO.setIdade(funcionarioDTO.getIdade());
        funcionarioDTO.setDepartamentos(funcionarioModel.getDepartamentos());

        return funcionarioDTO;
    }

}
