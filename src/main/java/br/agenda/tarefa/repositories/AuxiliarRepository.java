package br.agenda.tarefa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.agenda.tarefa.domain.Auxiliar;

public interface AuxiliarRepository extends JpaRepository<Auxiliar, Integer>{
	
	Optional<Auxiliar> findByCpf(String cpf);
	
	Optional<Auxiliar> findByEmail(String email);

}
