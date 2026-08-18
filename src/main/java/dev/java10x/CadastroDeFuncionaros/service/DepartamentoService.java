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

    //Criar Departamento
    public DepartamentoModel criarDepartamento(DepartamentoModel departamento){
        return departamentoRepositry.save(departamento);
    }

    //deletar departamento - TEM QUE SER VOID
    public void deletarDepartamentoPorId(Long id){
        departamentoRepositry.deleteById(id);
    }

    // alterar funcionario
    public DepartamentoModel atualiarDepartamento(Long id, DepartamentoModel departamentoAtualizado){
        if(departamentoRepositry.existsById(id)){
            departamentoAtualizado.setId(id);
            departamentoRepositry.save(departamentoAtualizado);
        }
        return null;
    }


}
