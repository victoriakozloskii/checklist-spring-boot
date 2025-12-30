package com.example.meu_primeiro_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meu_primeiro_projeto.entity.Mensagem;
import com.example.meu_primeiro_projeto.repository.MensagemRepository;

import java.util.List;

@RestController
public class OlaController {

    @Autowired
    private MensagemRepository repositorio;

    @GetMapping("/ola")
    public List<Mensagem> listarMensagens() {
        // Se o banco estiver vazio, cria mensagens de teste
        if (repositorio.count() == 0) {
            repositorio.save(new Mensagem("Primeira mensagem salva no Banco! 🐘"));
            repositorio.save(new Mensagem("Segunda mensagem (aprendendo Spring)!"));
        }

        // Retorna a lista vinda do banco de dados
        return repositorio.findAll();
    }
}
