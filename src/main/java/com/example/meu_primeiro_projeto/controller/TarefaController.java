package com.example.meu_primeiro_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.meu_primeiro_projeto.service.TarefaService;

@Controller // Diz pro Spring: "Aqui tem endpoints de web!"
@RequestMapping("/checklist") // Tudo começa com /checklist
public class TarefaController {

    @Autowired // Injeta o serviço automaticamente e faz a ligação com a camada de serviço
    private TarefaService service;

    // 1. Mostrar a Página (GET)
    @GetMapping
    public String carregarChecklist(Model model) { // Pega as tarefas do Service e manda pro HTML

        model.addAttribute("tarefas", service.listarTodas()); // Adiciona a lista de tarefas ao modelo com o nome "tarefas"
        return "checklist"; // Vai abrir o arquivo checklist.html
    }

    // 2. Criar Tarefa (POST)
    @PostMapping("/criar") // postMapping para criar uma nova tarefa e serve para receber dados do formulario

    public String criarNovaTarefa(@RequestParam String descricao) { // RequestParam funciona para pegar o valor do campo descricao do formulario
        service.criarTarefa(descricao);
        return "redirect:/checklist"; // Recarrega a página para mostrar a nova tarefa
    }

    // 3. Deletar Tarefa (GET)
    @GetMapping("/deletar/{id}") // id da tarefa a ser deletada é passado na URL como um path variable
    public String deletarTarefa(@PathVariable Long id) {
        service.deletarTarefa(id);
        return "redirect:/checklist"; // Recarrega a página para mostrar a lista atualizada
    }

    // 4. Alternar Status (GET)
    @GetMapping("/concluir/{id}")
    public String concluirTarefa(@PathVariable Long id) { // id da tarefa a ter o status alterado é passado na URL como um path variable
        service.alternarStatus(id);
        return "redirect:/checklist";
    }
}

// Nessa classe TarefaController estamos definindo os endpoints para interagir com as tarefas
// Temos o endpoint para carregar a pagina com a lista de tarefas, criar uma nova tarefa,
// deletar uma tarefa e alternar o status de concluida para pendente e vice versa
// Cada metodo chama o respectivo metodo na camada de servico (TarefaService) para realizar a logica de negocio
// A anotacao @Controller indica que essa classe é um controlador do Spring MVC que lida com requisições web
// A anotacao @RequestMapping("/checklist") define o caminho base para todos os endpoints nessa classe e endpoints serve para definir as rotas da aplicacao
// As anotacoes @GetMapping e @PostMapping definem os metodos HTTP que cada endpoint responde