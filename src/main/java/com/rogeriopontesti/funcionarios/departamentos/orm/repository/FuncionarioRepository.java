package com.rogeriopontesti.funcionarios.departamentos.orm.repository;

import com.rogeriopontesti.funcionarios.departamentos.orm.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
    List<Funcionario> findByDepartamentoId(UUID departamentoId);
}
