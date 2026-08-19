package dev.java10x.CadastroDeFuncionaros.controller;

import dev.java10x.CadastroDeFuncionaros.dto.FuncionarioDTO;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import dev.java10x.CadastroDeFuncionaros.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

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
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionario){
        FuncionarioDTO funcionarioDTO = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso: " + funcionarioDTO.getName() + ", ID: " + funcionarioDTO.getId());
    }

    // Procurar todos funcionarios - READ
    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios(){
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    // Procurar por id - READ
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncionariosPorId(@PathVariable Long id){
        FuncionarioDTO funcionarios = funcionarioService.listarFuncionariosPorId(id);
        if(funcionarios != null){
            return ResponseEntity.ok(funcionarios);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com esse id não existe nos nossos registros");
        }

    }


    // Alterar dados dos funcionarios - UPDATE
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFuncionarioPorId(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){
        FuncionarioDTO funcionarios = funcionarioService.atualiarFuncionario(id, funcionarioDTO);
        if(funcionarios != null){
            return ResponseEntity.ok(funcionarios);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com esse id não foi encontrado");
        }
    }

    // Deletar ninja - DELETE
    @DeleteMapping("/deletar/{ID}")
    public ResponseEntity<String> deletarFuncionarioPorId(@PathVariable Long id){
        if(funcionarioService.listarFuncionariosPorId(id) != null){
            funcionarioService.deletarFuncionarioPorId(id);
            return ResponseEntity.ok("Funcionario com ID:" + id+  " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionario com id: " + id + " nao foi encontrado");
        }

    }

}