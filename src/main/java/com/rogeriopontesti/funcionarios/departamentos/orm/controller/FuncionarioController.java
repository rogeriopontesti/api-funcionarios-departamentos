package com.rogeriopontesti.funcionarios.departamentos.orm.controller;


import com.rogeriopontesti.funcionarios.departamentos.orm.entity.Funcionario;
import com.rogeriopontesti.funcionarios.departamentos.orm.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Funcionario findAll(@PathVariable UUID id) {
        return repository.findById(id).get();
    }

    @GetMapping(value = "/departamento/{id}")
    public List<Funcionario> findByDepartamentoId(@PathVariable UUID id) {
        return repository.findByDepartamentoId(id);
    }

    @PostMapping
    public Funcionario insert(@RequestBody Funcionario funcionario) {
        Funcionario fnc = repository.save(funcionario);
        return fnc;
    }

}
