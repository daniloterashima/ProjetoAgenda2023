package br.agenda.tarefa.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.agenda.tarefa.domain.Tarefa;
import br.agenda.tarefa.domain.enums.Perfil;

public class TarefaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "O campo NOME é requerido!")
	protected String nome;
	protected String comentario;
	protected String usuario;
	protected LocalDate dataCriacao;
	protected LocalDate dataConclusao;	
	

	public TarefaDTO() {

	}
	
	public TarefaDTO(Tarefa tec) {
		super();
		this.id = tec.getId();
		this.nome = tec.getNome();
		this.comentario = tec.getComentario();
		this.usuario = tec.getUsuario();
		this.dataCriacao = tec.getDataCriacao();
		this.dataConclusao = tec.getDataConclusao();
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
