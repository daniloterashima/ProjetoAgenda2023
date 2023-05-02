package br.agenda.tarefa.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.agenda.tarefa.domain.dtos.TarefaDTO;
import br.agenda.tarefa.domain.enums.Perfil;

@Entity
public class Tarefa {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	protected String comentario;
	protected String usuario;
	protected LocalDate dataCriacao;
	protected LocalDate dataConclusao;	
	
	
	public Tarefa() {
	}

	public Tarefa(Integer id, String nome, String comentario, String usuario,LocalDate dataCriacao, LocalDate dataConclusao) {
	}
	
	public Tarefa(TarefaDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.comentario = obj.getComentario();
		this.usuario = obj.getComentario();
		this.dataCriacao = obj.getDataCriacao();
		this.dataConclusao = obj.getDataConclusao();
	
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
		return comentario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	
	
}

