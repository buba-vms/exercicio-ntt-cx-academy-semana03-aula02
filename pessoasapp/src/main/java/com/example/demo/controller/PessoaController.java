package com.example.demo.controller;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

  private final PessoaServiceImpl pessoaService;

    public PessoaController(PessoaServiceImpl pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodasAsPessoas() {
        List<Pessoa> response = pessoaService.listarTodasAsPessoas();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> retornarPessoaPeloId(@PathVariable Long id) {
        Pessoa response = pessoaService.retornarPessoaPeloId(id);

        return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Pessoa> inserirPessoa(@RequestBody Pessoa pessoa) {

        Pessoa response =  pessoaService.inserirPessoa(pessoa);
        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaPeloId(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa response =  pessoaService.atualizarPessoaPeloId(id ,pessoa);
        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) Long id) {

        boolean success = pessoaService.deletarPessoaPeloId(id);

        return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();



}
}