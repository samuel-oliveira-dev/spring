package com.example.aplicacaojava.dtos;

import com.example.aplicacaojava.models.Funcionario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class NomeIdadeDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public NomeIdadeDto(Funcionario funcionario){
        this.nome = funcionario.getNome();
        this.idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
    }
}
