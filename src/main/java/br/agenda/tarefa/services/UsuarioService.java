package br.agenda.tarefa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.agenda.tarefa.domain.Auxiliar;
import br.agenda.tarefa.domain.Usuario;
import br.agenda.tarefa.domain.dtos.UsuarioDTO;
import br.agenda.tarefa.repositories.AuxiliarRepository;
import br.agenda.tarefa.repositories.UsuarioRepository;
import br.agenda.tarefa.services.exceptions.DataIntegrityViolationException;
import br.agenda.tarefa.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AuxiliarRepository auxiliarRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Usuario findById(Integer id) {
		Optional<Usuario> cli = usuarioRepository.findById(id);
		return cli.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario create(UsuarioDTO dto) {
		dto.setId(null);
		dto.setSenha(encoder.encode(dto.getSenha()));
		validaPorCpfEEmail(dto);
		Usuario cli = new Usuario(dto);
		return usuarioRepository.save(cli);
	}

	private void validaPorCpfEEmail(UsuarioDTO dto) {
		Optional<Auxiliar> pes = auxiliarRepository.findByCpf(dto.getCpf());
		if (pes.isPresent() && pes.get().getId() != dto.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		pes = auxiliarRepository.findByEmail(dto.getEmail());
		if (pes.isPresent() && pes.get().getId() != dto.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

	public Usuario update(Integer id, @Valid UsuarioDTO dto) {
		dto.setId(id);
		Usuario oldObj = this.findById(id);
		if (!dto.getSenha().equals(oldObj.getSenha())) {
			dto.setSenha(encoder.encode(dto.getSenha()));
		}
		this.validaPorCpfEEmail(dto);
		oldObj = new Usuario(dto);
		return usuarioRepository.save(oldObj);
	}

	public void delete(Integer id) {
		Usuario obj = this.findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
		}
		usuarioRepository.delete(obj);
	}

}
