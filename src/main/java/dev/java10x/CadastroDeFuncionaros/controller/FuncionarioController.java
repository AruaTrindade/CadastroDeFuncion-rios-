package dev.java10x.CadastroDeFuncionaros.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

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
    @GetMapping("/todos")
    public String mostrarTodosOsFuncionarios(){
        return "Mostrar todos os funcionarios";
    }

    // Procurar por id - READ
    @GetMapping("/todosID")
    public String mostrarTodosOsFuncionariosPorId(){
        return "Mostrar funcionario por id";
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