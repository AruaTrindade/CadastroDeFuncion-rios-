package dev.java10x.CadastroDeFuncionaros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", unique = true)
    private String nomeDoDepartamento;


    //Um departamento pode ter muitos funcionarios
    @OneToMany(mappedBy = "departamentos")
    @JsonIgnore
    private List<FuncionarioModel> funcionarios;

}
