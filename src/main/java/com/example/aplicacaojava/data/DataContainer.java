package com.example.aplicacaojava.data;

import com.example.aplicacaojava.models.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class DataContainer {
    public static class Funcionarios{
        public static ArrayList<Funcionario> funcionarios =  funcionarios = new ArrayList<Funcionario>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), "Operador", BigDecimal.valueOf(2009.44)),
                new Funcionario("Joao", LocalDate.of(1990, 5, 12), "Operador", BigDecimal.valueOf(2284.38)),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), "Coordenador", BigDecimal.valueOf(9836.14)),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), "Diretor", BigDecimal.valueOf(19119.88)),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), "Recepcionista", BigDecimal.valueOf(2234.68)),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), "Operador", BigDecimal.valueOf(1582.72)),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), "Contador", BigDecimal.valueOf(4071.84)),
                new Funcionario("Laura", LocalDate.of(1994, 8, 7), "Gerente", BigDecimal.valueOf(3017.45)),
                new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), "Eletricista", BigDecimal.valueOf(1606.85)),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), "Gerente", BigDecimal.valueOf(2799.93))
        ));
    }
}
