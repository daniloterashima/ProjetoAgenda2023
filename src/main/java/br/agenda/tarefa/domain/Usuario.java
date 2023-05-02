package br.agenda.tarefa.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.agenda.tarefa.domain.dtos.UsuarioDTO;
import br.agenda.tarefa.domain.enums.Perfil;

@Entity
public class Usuario extends Auxiliar {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Chamado> chamados = new ArrayList<>();

	public Usuario() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public Usuario(Integer id, String nome, String cpf, String email, String senha, LocalDate dataNascimento, String sexo) {
		super(id, nome, cpf, email, senha, dataNascimento, sexo);
		addPerfil(Perfil.USUARIO);
	}
	
		public Usuario(UsuarioDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.email = dto.getEmail();
		this.senha = dto.getSenha();
		this.perfis = dto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = dto.getDataCriacao();
		this.dataNascimento = dto.getDataNascimento();
		this.sexo = dto.getsexo();
	}

	public List<Chamado> getChamados() {
		return chamados;
	}
	
	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
}
