package com.example.meu_primeiro_projeto.entity;

import jakarta.persistence.Entity; // 1. Importa a anotação Entity que diz que isso vira uma tabela no banco
import jakarta.persistence.GeneratedValue; // 2. Importa a anotação GeneratedValue que diz como o ID será gerado
import jakarta.persistence.GenerationType; // 3. Importa a enumeração GenerationType que define as estratégias de geração de ID 
import jakarta.persistence.Id; // 4. Importa a anotação Id que diz que aquele campo é a chave primária

@Entity // 1. Diz que isso vai virar uma tabela no banco
public class Mensagem {

    @Id // 2. Diz que este campo é a Chave Primária (ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. O banco gera o número sozinho (1, 2, 3...)
    private Long id;

    private String texto;

    // O JPA exige um construtor vazio
    public Mensagem() {
    }

    public Mensagem(String texto) { // Construtor para facilitar a criação do objeto
        this.texto = texto;
    }

    public String getTexto() { // Getter para o texto e serve para o JSON 
        return texto;
    }
    
    public Long getId() { // Getter para o id 
        return id;
    }
}
