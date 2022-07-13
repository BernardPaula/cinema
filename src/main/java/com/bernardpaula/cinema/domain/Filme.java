package com.bernardpaula.cinema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bernardpaula.cinema.domain.enums.EnumGeneroFilme;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "filme")
public class Filme implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo Obrigatório!")
	@Length(min=1, max=80, message = "O tamanho deve estar entre 1 e 80 caracteres.")
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "duracao")
	private Double duracao;
	
	@Column(name= "genero")
	private EnumGeneroFilme genero;
	
	@JsonIgnore
	private String senha;
	
	
	
	@OneToMany(mappedBy = "filme", cascade=CascadeType.ALL)
	private List<Ingresso> ingressos = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "filmes")
	private List<Ator> atores = new ArrayList<>();

	
	public Filme() {
		
	}

	public Filme(Integer id,
			@NotEmpty(message = "Campo Obrigatório!") @Length(min = 1, max = 80, message = "O tamanho deve estar entre 1 e 80 caracteres.") String titulo,
			Double duracao, EnumGeneroFilme genero, String senha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Double getDuracao() {
		return duracao;
	}


	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}


	public EnumGeneroFilme getGenero() {
		return genero;
	}


	public void setGenero(EnumGeneroFilme genero) {
		this.genero = genero;
	}


	public List<Ingresso> getIngressos() {
		return ingressos;
	}


	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}


	public List<Ator> getAtores() {
		return atores;
	}


	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
