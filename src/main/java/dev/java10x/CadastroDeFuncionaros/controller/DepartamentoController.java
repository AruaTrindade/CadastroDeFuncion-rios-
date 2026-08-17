package dev.java10x.CadastroDeFuncionaros.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
    //CRUD:


    // Adcionar Departamento - CREATE
    @PostMapping("/criar")
    public String criarDepartamento(){
        return "Departamento criado";
    }

    // Procurar todos Departamentos - READ
    @GetMapping("/todos")
    public String mostrarTodosOsDepartamentos(){
        return "Mostrar todos os departamentos";
    }

    // Procurar por id - READ
    @GetMapping("/todosID")
    public String mostrarTodosOsDepartamentosPorId(){
        return "Mostrar Departamentos por id";
    }


    // Alterar dados dos Departamentos - UPDATE
    @PutMapping("/alterarID")
    public String alterarDepartamentoPorId(){
        return "Departamento alterado";
    }

    // Deletar Departamento - DELETE
    @DeleteMapping("/deletarID")
    public String deletarDepartamentoPorId(){
        return "Departamento deletado por id";
    }
}
