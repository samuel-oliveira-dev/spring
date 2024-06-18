package com.example.aplicacaojava.controllers;

import com.example.aplicacaojava.data.DataContainer;
import com.example.aplicacaojava.dtos.FuncionarioDto;
import com.example.aplicacaojava.dtos.NomeIdadeDto;
import com.example.aplicacaojava.dtos.NomeSalarioMinimoDto;
import com.example.aplicacaojava.models.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
public class FuncionarioController {


    @GetMapping("/funcionarios")
    public ResponseEntity<ArrayList<Funcionario>> getFuncionario(){
        Funcionario f1 = new Funcionario("Fulano", LocalDate.now(), "programador", BigDecimal.valueOf(4646));
        return ResponseEntity.status(HttpStatus.OK).body(DataContainer.Funcionarios.funcionarios);
    }

    @GetMapping("/remover-joao")
    public ResponseEntity<List<Funcionario>> removerJoao(){
        List<Funcionario> novaLista = DataContainer.Funcionarios.funcionarios.stream().filter(func -> !func.nome.equals("Joao")).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(novaLista);
    }

    @GetMapping("imprimir-formatado")
    public ResponseEntity<ArrayList<FuncionarioDto>> imprimirFormatado(){
        ArrayList<FuncionarioDto> novaLista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario funcionario: DataContainer.Funcionarios.funcionarios
             ) {
            novaLista.add(new FuncionarioDto(funcionario));
        }
        return ResponseEntity.status(HttpStatus.OK).body(novaLista);
    }

    @GetMapping("/agrupar-funcionarios")
    public ResponseEntity<Map<String, List<Funcionario>>> agrupar(){
        Map<String, List<Funcionario>> funcionariosPorCargo =DataContainer.Funcionarios.funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosPorCargo);
    }

    @GetMapping("/aniversariantes")
    public ResponseEntity<List<Funcionario>> aniversariantes(){
        List<Funcionario> novaLista = DataContainer.Funcionarios.funcionarios.stream().filter(func -> func.dataNascimento.getMonth().getValue() == 10 || func.dataNascimento.getMonth().getValue() == 12 ).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(novaLista);

    }

    @GetMapping("/mais-velho")
    public ResponseEntity<NomeIdadeDto> maisVelho(){
        Funcionario funcionarioMaisAntigo = DataContainer.Funcionarios.funcionarios.stream()
                .min((func1, func2) -> func1.getDataNascimento().compareTo(func2.getDataNascimento()))
                .orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(new NomeIdadeDto(funcionarioMaisAntigo));
    }

    @GetMapping("/ordem-alfabetica")
    public ResponseEntity<List<Funcionario>> ordermAlfabetica(){
        List<Funcionario> novaLista = DataContainer.Funcionarios.funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(novaLista);
    }

    @GetMapping("/soma-salarios")
    public ResponseEntity<BigDecimal> somaSalarios(){
        BigDecimal soma = DataContainer.Funcionarios.funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.status(HttpStatus.OK).body(soma);
    }
    @GetMapping("/salarios-minimos")
    public ResponseEntity<ArrayList<NomeSalarioMinimoDto>> salariosMinimos(){
        ArrayList<NomeSalarioMinimoDto> nomeSalarioMinimoDtos = new ArrayList<NomeSalarioMinimoDto>();
        for (Funcionario funcionario: DataContainer.Funcionarios.funcionarios
             ) {
            nomeSalarioMinimoDtos.add(new NomeSalarioMinimoDto(funcionario));

        }
        return ResponseEntity.status(HttpStatus.OK).body(nomeSalarioMinimoDtos);

    }
}
