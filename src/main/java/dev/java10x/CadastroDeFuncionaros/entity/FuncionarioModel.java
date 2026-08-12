package dev.java10x.CadastroDeFuncionaros.entity;

import jakarta.persistence.*;

//Entity transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer idade;

    public FuncionarioModel(){

    }

    public FuncionarioModel(String name, String email, Integer idade) {
        this.name = name;
        this.email = email;
        this.idade = idade;
    }



}
