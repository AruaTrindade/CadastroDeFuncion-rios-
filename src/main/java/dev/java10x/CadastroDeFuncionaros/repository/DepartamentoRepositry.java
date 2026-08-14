package dev.java10x.CadastroDeFuncionaros.repository;

import dev.java10x.CadastroDeFuncionaros.entity.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositry extends JpaRepository<DepartamentoModel, Long> {

}
