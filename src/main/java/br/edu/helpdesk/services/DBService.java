package br.edu.helpdesk.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.helpdesk.domain.Chamado;
import br.edu.helpdesk.domain.Cliente;
import br.edu.helpdesk.domain.Tecnico;
import br.edu.helpdesk.domain.enums.Perfil;
import br.edu.helpdesk.domain.enums.Prioridade;
import br.edu.helpdesk.domain.enums.Status;
import br.edu.helpdesk.repositories.ChamadoRepository;
import br.edu.helpdesk.repositories.ClienteRepository;
import br.edu.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instaciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Primeira tarefa", "Essa é a primeira tarefa da familia");
		
		Tecnico tec2 = new Tecnico(null, "Segunda tarefa", "Essa é a segunda tarefa da familia");
		
		Cliente cli1 = new Cliente(null, "Primeiro Acesso", "15838367059", "primeiroacesso@gmail.com", encoder.encode("123456"), LocalDate.of(2023, 01, 01), "M");
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));		
		
	}

}
