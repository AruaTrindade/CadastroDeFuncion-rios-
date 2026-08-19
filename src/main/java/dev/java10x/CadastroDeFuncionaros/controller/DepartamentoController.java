package dev.java10x.CadastroDeFuncionaros.controller;


import dev.java10x.CadastroDeFuncionaros.dto.DepartamentoDTO;
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
    public DepartamentoDTO criarDepartamento(@RequestBody DepartamentoDTO departamentoDTO){
        return departamentoService.criarDepartamento(departamentoDTO);
    }

    // Procurar todos Departamentos - READ
    @GetMapping("/listar")
    public List<DepartamentoDTO> listarDepartamentos(){
        return departamentoService.listarDepartamentos();
    }

    // Procurar por id - READ
    @GetMapping("/listar/{id}")
    public DepartamentoDTO listarDepartamentosPorId(@PathVariable Long id){
        return departamentoService.listarDepartamentosPorId(id);
    }


    // Alterar dados dos Departamentos - UPDATE
    @PutMapping("/alterar/{id}")
    public DepartamentoDTO alterarDepartamentoPorId(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO){
        return departamentoService.atualizarDepartamento(id, departamentoDTO);
    }

    // Deletar Departamento - DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletarDepartamentoPorId(@PathVariable Long id){
        departamentoService.deletarDepartamentoPorId(id);
    }

}
