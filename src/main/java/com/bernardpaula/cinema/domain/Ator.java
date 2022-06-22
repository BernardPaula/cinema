package com.bernardpaula.cinema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ator")
public class Ator implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", unique = true)
	@NotEmpty(message = "Campo obrigatório!")
	@Length(min=1, max=80, message = "O tamanho deve estar entre 1 e 80 caracteres")
	private String nome;
	
	@Column(name = "papel_do_ator")
	@NotEmpty(message = "Campo obrigatório!")
	@Length(min=1, max=80, message = "O tamanho deve estar entre 1 e 80 caracteres")
	private String papelDoAtor;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ator_filme",
		joinColumns = @JoinColumn(name = "ator_id"),
		inverseJoinColumns = @JoinColumn(name = "filme_id"))
	private List<Filme> filmes = new ArrayList<>();
	
	
	public Ator() {
	}

	public Ator(Integer id,
			@NotEmpty(message = "Campo obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres") String nome,
			@NotEmpty(message = "Campo obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres") String papelDoAtor) {
		super();
		this.id = id;
		this.nome = nome;
		this.papelDoAtor = papelDoAtor;
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

	public String getPapelDoAtor() {
		return papelDoAtor;
	}

	public void setPapelDoAtor(String papelDoAtor) {
		this.papelDoAtor = papelDoAtor;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	
	
}
