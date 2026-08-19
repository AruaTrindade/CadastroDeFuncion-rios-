package dev.java10x.CadastroDeFuncionaros.service;

import dev.java10x.CadastroDeFuncionaros.dto.DepartamentoDTO;
import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.mapper.DepartamentoMapper;
import dev.java10x.CadastroDeFuncionaros.repository.DepartamentoRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {
    private final DepartamentoRepositry departamentoRepositry;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoService(DepartamentoRepositry departamentoRepositry, DepartamentoMapper departamentoMapper) {
        this.departamentoRepositry = departamentoRepositry;
        this.departamentoMapper = departamentoMapper;
    }

    // Listar todos os meus departamentos
    public List<DepartamentoDTO> listarDepartamentos(){
        List<DepartamentoModel> departamento = departamentoRepositry.findAll();
        return departamento.stream()
                .map(departamentoMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por ID
    public DepartamentoDTO listarDepartamentosPorId(Long id){
        Optional<DepartamentoModel> departamentoPorId = departamentoRepositry.findById(id);
        return departamentoPorId.map(departamentoMapper::map).orElse(null);
    }

    //Criar Departamento
    public DepartamentoDTO criarDepartamento(DepartamentoDTO departamentoDTO){
        DepartamentoModel departamento = departamentoMapper.map(departamentoDTO);
        departamentoRepositry.save(departamento);
        return departamentoMapper.map(departamento);
    }

    //deletar departamento - TEM QUE SER VOID
    public void deletarDepartamentoPorId(Long id){
        departamentoRepositry.deleteById(id);
    }

    // alterar funcionario
    public DepartamentoDTO atualizarDepartamento(Long id, DepartamentoDTO departamentoDTO){
        Optional<DepartamentoModel> departamentoExistente = departamentoRepositry.findById(id);
        if (departamentoExistente.isPresent()){
            DepartamentoModel departamentoAtualizado = departamentoMapper.map(departamentoDTO);
            departamentoAtualizado.setId(id);
            DepartamentoModel departamentoSalvo = departamentoRepositry.save(departamentoAtualizado);
            return departamentoMapper.map(departamentoSalvo);
        }
        return null;
    }


}
