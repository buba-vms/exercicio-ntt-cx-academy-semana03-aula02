package com.example.demo.service;

import com.example.demo.model.Pessoa;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PessoaService {
    List<Pessoa> listarTodasAsPessoas();

    Pessoa retornarPessoaPeloId(Long id);

    Pessoa inserirPessoa(Pessoa pessoa);

    Pessoa atualizarPessoaPeloId(Long id, Pessoa pessoa);

    boolean deletarPessoaPeloId(Long id);
}
