package com.bernardpaula.cinema.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sala")
public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "n_assentos")
	private Integer nAssentos;
	
	@Column(name = "tipo_tela")
	private String TipoTela;
	
	@Column(name = "localizacao")
	@NotEmpty(message = "Campo obrigatório")
	private String localizacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name= "sessao_id")
	private Sessao sessao;
	
	public Sala() {
		
	}

	public Sala(Integer id, Integer nAssentos, String tipoTela,
			@NotEmpty(message = "Campo obrigatório") String localizacao) {
		super();
		this.id = id;
		this.nAssentos = nAssentos;
		TipoTela = tipoTela;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getnAssentos() {
		return nAssentos;
	}

	public void setnAssentos(Integer nAssentos) {
		this.nAssentos = nAssentos;
	}

	public String getTipoTela() {
		return TipoTela;
	}

	public void setTipoTela(String tipoTela) {
		TipoTela = tipoTela;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
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
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
}
