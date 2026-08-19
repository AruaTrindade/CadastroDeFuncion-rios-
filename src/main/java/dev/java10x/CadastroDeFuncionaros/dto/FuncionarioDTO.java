package dev.java10x.CadastroDeFuncionaros.dto;

import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    private String name;

    private String email;

    private String imgUrl;

    private Integer idade;

    private DepartamentoModel departamentos;




}
