package com.example.demo.model;

import com.example.demo.utils.EstadoCivil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataDeNascimento;
    private EstadoCivil estadoCivil;
    private String telefone;
    private String email;


}
