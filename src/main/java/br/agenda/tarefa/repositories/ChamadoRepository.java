package br.agenda.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.agenda.tarefa.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
