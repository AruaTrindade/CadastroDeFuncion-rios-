package dev.java10x.CadastroDeFuncionaros.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private Long id;

    private String nomeDoDepartamento;

    private List<FuncionarioModel> funcionarios;

    private String responsavel;
}
