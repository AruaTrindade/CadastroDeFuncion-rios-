package dev.java10x.CadastroDeFuncionaros.controller;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem";
    }
    //CRUD:


    // Adcionar funcionario - CREATE
    @PostMapping("/criar")
    public FuncionarioDTO criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.criarFuncionario(funcionarioDTO);
    }

    // Procurar todos funcionarios - READ
    @GetMapping("/listar")
    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    // Procurar por id - READ
    @GetMapping("/listar/{id}")
    public FuncionarioModel listarFuncionariosPorId(@PathVariable Long id){
        return funcionarioService.listarFuncionariosPorId(id);
    }


    // Alterar dados dos funcionarios - UPDATE
    @PutMapping("/alterar/{id}")
    public FuncionarioModel alterarFuncionarioPorId(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.atualiarFuncionario(id, funcionarioModel);
    }

    // Deletar ninja - DELETE
    @DeleteMapping("/deletar/{ID}")
    public void deletarFuncionarioPorId(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }

}