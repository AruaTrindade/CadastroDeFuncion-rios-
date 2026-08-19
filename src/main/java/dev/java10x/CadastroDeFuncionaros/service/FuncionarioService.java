package dev.java10x.CadastroDeFuncionaros.service;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.mapper.FuncionarioMapper;
import dev.java10x.CadastroDeFuncionaros.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
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
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    //Deletar funcionario - TEM QUE SER VOID
    public void deletarFuncionarioPorId(Long id){
        funcionarioRepository.deleteById(id);
    }

    // alterar funcionario
    public FuncionarioModel atualiarFuncionario(Long id, FuncionarioModel funcionarioAtualizado){
        if(funcionarioRepository.existsById(id)){
            funcionarioAtualizado.setId(id);
            funcionarioRepository.save(funcionarioAtualizado);
        }
        return null;
    }



}
