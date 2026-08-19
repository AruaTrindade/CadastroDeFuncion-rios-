package dev.java10x.CadastroDeFuncionaros.service;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.mapper.FuncionarioMapper;
import dev.java10x.CadastroDeFuncionaros.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    // Listar todos os meus ninjas
    public List<FuncionarioDTO> listarFuncionarios(){
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por ID
    public FuncionarioDTO listarFuncionariosPorId(Long id){
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);
        return funcionarioPorId.map(funcionarioMapper::map).orElse(null);
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
    public FuncionarioDTO atualiarFuncionario(Long id, FuncionarioDTO funcionarioDTO){
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()){
            FuncionarioModel funcionarioAtualzado = funcionarioMapper.map(funcionarioDTO);
            funcionarioAtualzado.setId(id);
            FuncionarioModel funcionarioSalvo = funcionarioRepository.save(funcionarioAtualzado);
            return funcionarioMapper.map(funcionarioSalvo);
        }
        return null;
    }



}
