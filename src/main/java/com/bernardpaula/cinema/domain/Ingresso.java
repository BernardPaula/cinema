package com.bernardpaula.cinema.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bernardpaula.cinema.domain.enums.EnumCategoriaIngresso;
import com.bernardpaula.cinema.domain.enums.EnumTipoIngresso;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private EnumTipoIngresso tipo;
	private EnumCategoriaIngresso categoria;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	
	
	public Ingresso() {		
	}


	public Ingresso(Integer id, EnumTipoIngresso tipo, EnumCategoriaIngresso categoria, Filme filme) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.categoria = categoria;
		this.filme = filme;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public EnumTipoIngresso getTipo() {
		return tipo;
	}


	public void setTipo(EnumTipoIngresso tipo) {
		this.tipo = tipo;
	}


	public EnumCategoriaIngresso getCategoria() {
		return categoria;
	}


	public void setCategoria(EnumCategoriaIngresso categoria) {
		this.categoria = categoria;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
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
		Ingresso other = (Ingresso) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
