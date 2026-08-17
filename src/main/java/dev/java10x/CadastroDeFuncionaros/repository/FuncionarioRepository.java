package dev.java10x.CadastroDeFuncionaros.repository;

import dev.java10x.CadastroDeFuncionaros.entity.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
