package com.example.demo.service;

import com.example.demo.handler.exceptions.RecursoNaoEncontradoExeception;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService{
    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> listarTodasAsPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa retornarPessoaPeloId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExeception("Pessoa não encontrada com id " + id));
    }

    @Override
    public Pessoa inserirPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa atualizarPessoaPeloId(Long id, Pessoa pessoa) {
        Pessoa pessoaAtualizada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExeception("Pessoa não encontrada com id " + id));

        if (pessoa.getNome() != null) {
            pessoaAtualizada.setNome(pessoa.getNome());
        }
        if (pessoa.getCpf() != null) {
            pessoaAtualizada.setCpf(pessoa.getCpf());
        }
        if (pessoa.getRg() != null) {
            pessoaAtualizada.setRg(pessoa.getRg());
        }
        if (pessoa.getDataDeNascimento() != null) {
            pessoaAtualizada.setDataDeNascimento(pessoa.getDataDeNascimento());
        }
        if (pessoa.getEstadoCivil() != null) {
            pessoaAtualizada.setEstadoCivil(pessoa.getEstadoCivil());
        }
        if (pessoa.getTelefone() != null) {
            pessoaAtualizada.setTelefone(pessoa.getTelefone());
        }
        if (pessoa.getEmail() != null) {
            pessoaAtualizada.setEmail(pessoa.getEmail());
        }

        return pessoaRepository.save(pessoaAtualizada);
    }

    @Override
    public boolean deletarPessoaPeloId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExeception("Pessoa não encontrada com id " + id));

        pessoaRepository.delete(pessoa);
        return true;
    }


}
