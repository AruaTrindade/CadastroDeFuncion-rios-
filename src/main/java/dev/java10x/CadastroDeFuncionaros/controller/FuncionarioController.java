package dev.java10x.CadastroDeFuncionaros.controller;

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
    public String criarFuncionario(){
        return "Funcionario criado";
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
    @PutMapping("/alterarID")
    public String alterarFuncionarioPorId(){
        return "Funcionario alterado";
    }

    // Deletar ninja - DELETE
    @DeleteMapping("/deletarID")
    public String deletarFuncionarioPorId(){
        return "Ninja deletado por id";
    }

}