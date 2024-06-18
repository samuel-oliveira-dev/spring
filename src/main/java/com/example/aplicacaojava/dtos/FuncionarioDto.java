package com.example.aplicacaojava.dtos;

import com.example.aplicacaojava.models.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FuncionarioDto {
    public String funcao;
    public String salario;
    public String nome;
    public String dataNascimento;
    public FuncionarioDto(Funcionario funcionario){
        this.nome = funcionario.getNome();
        this.dataNascimento = formatData(funcionario.getDataNascimento());
        this.funcao = funcionario.getFuncao();
        this.salario = formatDecimal(funcionario.getSalario());
    }

    private String formatData(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(date);
    }
    private String formatDecimal(BigDecimal decimal){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(decimal);
    }
}
