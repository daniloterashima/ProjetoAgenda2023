package br.edu.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.helpdesk.domain.Tecnico;
import br.edu.helpdesk.domain.enums.Perfil;

public class TecnicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "O campo NOME é requerido!")
	protected String nome;
	@NotNull(message = "O campo CPF é requerido!")
	protected String cpf;
	@NotNull(message = "O campo E-MAIL é requerido!")
	protected String email;
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	public LocalDate dataNascimento;
	public String sexo;

	public TecnicoDTO() {
		super();
		addPerfil(Perfil.TECNICO);
	}
	
	public TecnicoDTO(Tecnico tec) {
		super();
		this.id = tec.getId();
		this.nome = tec.getNome();
		this.cpf = tec.getCpf();
		this.email = tec.getEmail();
		this.senha = tec.getSenha();
		this.perfis = tec.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = tec.getDataCriacao();
		this.dataNascimento = tec.getDataNascimento();
		this.sexo = tec.getsexo();
		addPerfil(Perfil.TECNICO);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public LocalDate getdataNascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getsexo() {
		return sexo;
	}

	public void setsexo(String sexo) {
		this.sexo = sexo;
	}
	
}
