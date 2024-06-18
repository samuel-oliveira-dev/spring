package com.example.aplicacaojava.dtos;

import com.example.aplicacaojava.models.Funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NomeSalarioMinimoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private BigDecimal salariosMinimos;
    private final BigDecimal BASE = new BigDecimal("1212.00");

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalariosMinimos() {
        return salariosMinimos;
    }

    public void setSalariosMinimos(BigDecimal salariosMinimos) {
        this.salariosMinimos = salariosMinimos;
    }
    public NomeSalarioMinimoDto(Funcionario funcionario){
        this.nome = funcionario.getNome();
        this.salariosMinimos =  funcionario.getSalario().divide(BASE, 2, RoundingMode.HALF_UP);

    }
}
