package com.example.meu_primeiro_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.meu_primeiro_projeto.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // O Spring já cria o .save(), .findAll(), .deleteById() automaticamente!
}

// Nessa interface TarefaRepository estamos estendendo JpaRepository que é uma interface do Spring Data JPA que fornece metodos padroes para interagir com o banco de dados
// A anotacao @Repository indica que essa interface é um componente de repositório do Spring, responsável por encapsular a lógica de acesso aos dados

