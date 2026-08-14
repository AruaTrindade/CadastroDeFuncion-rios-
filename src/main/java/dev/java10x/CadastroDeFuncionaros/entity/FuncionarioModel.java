package dev.java10x.CadastroDeFuncionaros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer idade;

    //@manyToOne um funcionario possui uma unica missao
    @ManyToOne
    @JoinColumn(name = "departamentos_id") //Chave estrangeira / foreing key
    private DepartamentoModel departamentos;



}
