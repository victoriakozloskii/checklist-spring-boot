package com.example.meu_primeiro_projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.meu_primeiro_projeto.entity.Tarefa;
import com.example.meu_primeiro_projeto.repository.TarefaRepository;
import java.util.List;

@Service // Diz pro Spring: "Aqui tem regras de negócio!"
public class TarefaService {

    @Autowired // Injeta o repositório automaticamente e faz a ligação com o banco de dados
    private TarefaRepository repositorio; // atributo repositorio do tipo TarefaRepository 

    // 1. Listar todas
    public List<Tarefa> listarTodas() { // metodo para listar todas as tarefas 
        return repositorio.findAll(); // usa o metodo findAll do JpaRepository para buscar todas as tarefas no banco de dados 
    }

    // 2. Criar nova tarefa
    public void criarTarefa(String descricao) { // metodo para criar uma nova tarefa recebendo a descricao como parametro
        Tarefa nova = new Tarefa(descricao); // cria uma nova instancia de Tarefa com a descricao passada
        repositorio.save(nova); // salva a nova tarefa no banco de dados usando o metodo save do JpaRepository
    }

    // 3. Deletar tarefa
    public void deletarTarefa(Long id) {
        repositorio.deleteById(id);
    }

    // 4. Marcar como Concluída/Pendente (A lógica inteligente!)
    public void alternarStatus(Long id) {
        // Busca a tarefa no banco pelo ID
        var tarefa = repositorio.findById(id).orElse(null); // Se não encontrar, retorna null e byId serve para buscar pelo id e orElse para retornar null se nao encontrar
        
        if (tarefa != null) {
            // Se estava true vira false, se estava false vira true
            tarefa.setConcluida(!tarefa.isConcluida());
            repositorio.save(tarefa); // Salva a alteração
        }
    }
}
// Nessa classe TarefaService estamos implementando a logica de negocio para gerenciar as tarefas
// aqui temos os metodos para listar todas as tarefas, criar uma nova tarefa, deletar uma tarefa e alternar o status de concluida para pendente e vice versa
