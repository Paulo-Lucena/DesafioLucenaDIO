package com.cadastrofuncionario.CadastroDeFuncionarios.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID é gerado auto
    private Long id;

    @Column(nullable = false) //not null
    private String nome;

    @Column(nullable = false, unique = true) //not null, unique = somente CPF unico entra
    private String cpf;

    private LocalDate datanascimento;

    private LocalDate dataContratacao;

    private LocalDate datadesligamento;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @Column(nullable = false) //not null
    private List<Departamento> setor;
}
