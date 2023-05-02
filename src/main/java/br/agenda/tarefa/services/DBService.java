package br.agenda.tarefa.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.agenda.tarefa.domain.Chamado;
import br.agenda.tarefa.domain.Tarefa;
import br.agenda.tarefa.domain.Usuario;
import br.agenda.tarefa.domain.enums.Perfil;
import br.agenda.tarefa.domain.enums.Prioridade;
import br.agenda.tarefa.domain.enums.Status;
import br.agenda.tarefa.repositories.ChamadoRepository;
import br.agenda.tarefa.repositories.TarefaRepository;
import br.agenda.tarefa.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instaciaDB() {
		
		Tarefa tar1 = new Tarefa(null, "Primeira tarefa", "Essa é a primeira tarefa da familia","", null, null);
		
		Usuario usr1 = new Usuario(null, "Primeiro Acesso", "15838367059", "primeiroacesso@gmail.com", encoder.encode("123456"), LocalDate.of(2023, 01, 01), "M");
		
		tarefaRepository.saveAll(Arrays.asList(tar1));
		usuarioRepository.saveAll(Arrays.asList(usr1));		
		
	}

}
