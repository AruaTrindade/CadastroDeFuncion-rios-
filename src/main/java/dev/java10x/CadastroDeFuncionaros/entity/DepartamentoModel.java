package dev.java10x.CadastroDeFuncionaros.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoDepartamento;


    //Um departamento pode ter muitos funcionarios
    @OneToMany(mappedBy = "departamentos")
    private List<FuncionarioModel> funcionarios;

}
