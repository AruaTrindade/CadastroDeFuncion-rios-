package dev.java10x.CadastroDeFuncionaros.service;

import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.repository.DepartamentoRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private DepartamentoRepositry departamentoRepositry;


    public DepartamentoService(DepartamentoRepositry departamentoRepositry) {
        this.departamentoRepositry = departamentoRepositry;
    }

    // Listar todos os meus departamentos
    public List<DepartamentoModel> listarDepartamentos(){
        return departamentoRepositry.findAll();
    }

    //Listar por ID
    public DepartamentoModel listarDepartamentosPorId(Long id){
        Optional<DepartamentoModel> departamentoModel = departamentoRepositry.findById(id);
        return departamentoModel.orElse(null);
    }

}
