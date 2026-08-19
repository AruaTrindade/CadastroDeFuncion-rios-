package dev.java10x.CadastroDeFuncionaros.mapper;

import dev.java10x.CadastroDeFuncionaros.dto.DepartamentoDTO;
import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public DepartamentoModel map(DepartamentoDTO departamentoDTO){
        DepartamentoModel departamentoModel =  new DepartamentoModel();

        departamentoModel.setId(departamentoDTO.getId());
        departamentoModel.setNomeDoDepartamento(departamentoDTO.getNomeDoDepartamento());
        departamentoModel.setResponsavel(departamentoDTO.getResponsavel());
        departamentoModel.setFuncionarios(departamentoDTO.getFuncionarios());

        return  departamentoModel;
    }

    public DepartamentoDTO map(DepartamentoModel departamentoModel){
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();

        departamentoDTO.setId(departamentoModel.getId());
        departamentoDTO.setNomeDoDepartamento(departamentoModel.getNomeDoDepartamento());
        departamentoDTO.setResponsavel(departamentoModel.getResponsavel());
        departamentoDTO.setFuncionarios(departamentoModel.getFuncionarios());

        return departamentoDTO;
    }

}
