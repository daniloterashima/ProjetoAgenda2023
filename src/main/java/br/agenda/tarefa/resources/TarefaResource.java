package br.agenda.tarefa.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.agenda.tarefa.domain.Tarefa;
import br.agenda.tarefa.domain.dtos.TarefaDTO;
import br.agenda.tarefa.services.TarefaService;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaResource {
	
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Integer id) {
		Tarefa tarefa = this.tarefaService.findById(id);
		return ResponseEntity.ok().body(new TarefaDTO(tarefa));
	}

	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll(){
		List<Tarefa> list = tarefaService.findAll();
		List<TarefaDTO> listDTO = list.stream().map(t -> new TarefaDTO(t)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> create(@Valid @RequestBody TarefaDTO tecDTO){
		Tarefa tec = tarefaService.create(tecDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tec.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> update(@PathVariable Integer id, @Valid @RequestBody TarefaDTO objDTO){	
		Tarefa obj = tarefaService.update(id, objDTO);
		return ResponseEntity.ok().body(new TarefaDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> delete(@PathVariable Integer id){
		tarefaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
