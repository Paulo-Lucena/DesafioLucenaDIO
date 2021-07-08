package com.cadastrofuncionario.CadastroDeFuncionarios.entity;


import com.cadastrofuncionario.CadastroDeFuncionarios.enums.NomesDepartamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID é gerado auto
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) //not null
    private NomesDepartamento nome;


}
