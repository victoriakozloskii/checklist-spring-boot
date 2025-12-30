package com.example.meu_primeiro_projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serve para saber que o id é auto increment evita erros
    private Long id; // chave primaria

    private String descricao; // atributo descricao e serve para descrever a tarefa
    private boolean concluida; // atributo concluida e serve

    private Tarefa(){} // construtor padrao do JPA e necessario para o funcionamento do JPA

    // Construtor para criar tarefa nova (começa sempre como não concluída)
    public Tarefa(String descricao) { // construtor para criar uma nova tarefa com a descricao passada como parametro
        this.descricao = descricao; // atribui a descricao passada ao atributo descricao
        this.concluida = false; // por padrao a tarefa nao esta concluida

    }
    // Getters e Setters para os atributos e para java poder ler e escrver neles
    public Long getId() {return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }

    // nessa parte estamos sobrescrevendo o metodo toString para facilitar a visualizacao das tarefas no console e
}
