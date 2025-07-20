package com.rogeriopontesti.funcionarios.departamentos.orm.repository;

import com.rogeriopontesti.funcionarios.departamentos.orm.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {
}
