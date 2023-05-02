package br.agenda.tarefa.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.agenda.tarefa.domain.Chamado;
import br.agenda.tarefa.domain.Tarefa;
import br.agenda.tarefa.domain.Usuario;
import br.agenda.tarefa.domain.dtos.ChamadoDTO;
import br.agenda.tarefa.domain.enums.Prioridade;
import br.agenda.tarefa.domain.enums.Status;
import br.agenda.tarefa.repositories.ChamadoRepository;
import br.agenda.tarefa.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private UsuarioService usuarioService;

	public Chamado findById(Integer id) {
		Optional<Chamado> cham = chamadoRepository.findById(id);
		return cham.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}

	public List<Chamado> findAll() {
		List<Chamado> list = chamadoRepository.findAll();
		return list;
	}

	public Chamado create(ChamadoDTO dto) {
		return chamadoRepository.save(this.newChamado(dto));
	}
	
	private Chamado newChamado(ChamadoDTO dto) {
		Usuario cli = usuarioService.findById(dto.getCliente());
		
		Chamado cham = new Chamado();
		if (dto.getId() != null) {
			cham.setId(dto.getId());
		}
		if (dto.getStatus().equals(2)) {
			cham.setDataFechamento(LocalDate.now());
		}
		cham.setUsuario(cli);
		cham.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
		cham.setStatus(Status.toEnum(dto.getStatus()));
		cham.setObservacao(dto.getObservacao());
		cham.setTitulo(dto.getTitulo());
		return cham;
	}

	public Chamado update(Integer id, @Valid ChamadoDTO dto) {
		dto.setId(id);
		Chamado cham = this.findById(id);
		cham = newChamado(dto);
		return chamadoRepository.save(cham);
	}
	
	

}
