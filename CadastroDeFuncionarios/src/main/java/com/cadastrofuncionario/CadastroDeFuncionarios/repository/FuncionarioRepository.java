package com.cadastrofuncionario.CadastroDeFuncionarios.repository;

import com.cadastrofuncionario.CadastroDeFuncionarios.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
