package br.agenda.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.agenda.tarefa.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
