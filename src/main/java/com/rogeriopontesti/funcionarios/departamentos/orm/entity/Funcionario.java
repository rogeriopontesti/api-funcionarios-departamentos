package com.rogeriopontesti.funcionarios.departamentos.orm.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Column(name = "qtdd_dependentes", nullable = false)
    private int qtddDependentes;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    public Funcionario(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getQtddDependentes() {
        return qtddDependentes;
    }

    public void setQtddDependentes(int qtddDependentes) {
        this.qtddDependentes = qtddDependentes;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
