package br.agenda.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.agenda.tarefa.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
