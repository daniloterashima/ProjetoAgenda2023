package br.agenda.tarefa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.agenda.tarefa.domain.Tarefa;
import br.agenda.tarefa.domain.dtos.TarefaDTO;
import br.agenda.tarefa.repositories.TarefaRepository;
import br.agenda.tarefa.services.exceptions.ObjectNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Tarefa findById(Integer id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}

	public List<Tarefa> findAll() {
		return tarefaRepository.findAll();
	}

	public Tarefa create(TarefaDTO tecDTO) {
		tecDTO.setId(null);
		Tarefa tec = new Tarefa(tecDTO);
		return tarefaRepository.save(tec);
	}

	public Tarefa update(Integer id, @Valid TarefaDTO objDTO) {
		objDTO.setId(id);
		Tarefa oldObj = this.findById(id);
		oldObj = new Tarefa(objDTO);
		return tarefaRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Tarefa obj = this.findById(id);
		tarefaRepository.delete(obj);
	}

}
