package dev.java10x.CadastroDeFuncionaros.controller;


import dev.java10x.CadastroDeFuncionaros.dto.DepartamentoDTO;
import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarDepartamento(@RequestBody DepartamentoDTO departamento){
        DepartamentoDTO departamentoDTO = departamentoService.criarDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Departamento criado com sucesso: " + departamentoDTO.getNomeDoDepartamento() + ", ID: " + departamentoDTO.getId());
    }

    // Procurar todos Departamentos - READ
    @GetMapping("/listar")
    public List<DepartamentoDTO> listarDepartamentos(){
        return departamentoService.listarDepartamentos();
    }

    // Procurar por id - READ
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarDepartamentosPorId(@PathVariable Long id){
        DepartamentoDTO departamentos = departamentoService.listarDepartamentosPorId(id);
        if(departamentos != null){
            return ResponseEntity.ok(departamentos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("departamento com esse id não existe nos nossos registros");
        }

    }


    // Alterar dados dos Departamentos - UPDATE
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarDepartamentoPorId(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO){
        DepartamentoDTO departamentos = departamentoService.atualizarDepartamento(id, departamentoDTO);
        if(departamentos != null){
            return ResponseEntity.ok(departamentos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Departamento com esse id não foi encontrado");
        }
    }

    // Deletar Departamento - DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarDepartamentoPorId(@PathVariable Long id){
        if(departamentoService.listarDepartamentosPorId(id) != null){
            departamentoService.deletarDepartamentoPorId(id);
            return ResponseEntity.ok("Departamento com ID:" + id+  " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O departamento com id: " + id + " nao foi encontrado");
        }

    }

}
