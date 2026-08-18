package dev.java10x.CadastroDeFuncionaros.service;

import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Listar todos os meus ninjas
    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    //Listar por ID
    public FuncionarioModel listarFuncionariosPorId(Long id){
        Optional<FuncionarioModel> funcionarioModel = funcionarioRepository.findById(id);
        return funcionarioModel.orElse(null);
    }

    //Criar um novo Funcionario
    public FuncionarioModel criarFuncionario(FuncionarioModel funcionario){
        return funcionarioRepository.save(funcionario);
    }



}
