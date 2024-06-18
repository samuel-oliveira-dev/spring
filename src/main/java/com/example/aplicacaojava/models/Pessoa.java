package com.example.aplicacaojava.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Pessoa implements Serializable {
    public String nome;
    public LocalDate dataNascimento;
    private static final long serialVersionUID = 1L;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
