package dev.java10x.CadastroDeFuncionaros.controller;


import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.service.DepartamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }


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
    @GetMapping("/listar")
    public List<DepartamentoModel> listarDepartamentos(){
        return departamentoService.listarDepartamentos();
    }

    // Procurar por id - READ
    @GetMapping("/listarID")
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
