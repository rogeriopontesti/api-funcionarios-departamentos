package com.rogeriopontesti.funcionarios.departamentos.orm.controller;

import com.rogeriopontesti.funcionarios.departamentos.orm.entity.Departamento;
import com.rogeriopontesti.funcionarios.departamentos.orm.entity.Funcionario;
import com.rogeriopontesti.funcionarios.departamentos.orm.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository repository;

    @GetMapping
    public List<Departamento> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Departamento findAll(@PathVariable UUID id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Departamento insert(@RequestBody Departamento departamento) {
        return repository.save(departamento);
    }
}
