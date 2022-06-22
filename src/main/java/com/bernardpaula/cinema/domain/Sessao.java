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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "estado_da_sessao")
	private boolean estadoDaSessao; 
	
	@Column(name = "horario")
	private Integer horario;
	
	

	@OneToMany(mappedBy = "sessao", cascade=CascadeType.ALL)
	private List<Sala> salas = new ArrayList<>();
	
	
	public Sessao() {
		
	}

	public Sessao(Integer id, boolean estadoDaSessao, Integer horario) {
		super();
		this.id = id;
		this.estadoDaSessao = estadoDaSessao;
		this.horario = horario;
	}


	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEstadoDaSessao() {
		return estadoDaSessao;
	}

	public void setEstadoDaSessao(boolean estadoDaSessao) {
		this.estadoDaSessao = estadoDaSessao;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
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
		Sessao other = (Sessao) obj;
		return Objects.equals(id, other.id);
	}
		
}
