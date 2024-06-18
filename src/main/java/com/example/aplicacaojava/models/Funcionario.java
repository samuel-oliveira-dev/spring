package com.example.aplicacaojava.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    public String funcao;
    public BigDecimal salario;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Funcionario(String nome, LocalDate dataNascimento, String funcao, BigDecimal salario) {
        super(nome, dataNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }
}
