package ifsul.lp.entities;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Deputado")
public class Deputado implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255, unique=true)
	private String nomeCivil;
	
	@Column(length=50, unique=true)
	private String siglaPartido;
	
	@Column(length=2, unique=true)
	private String siglaUF;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "inscricoes", joinColumns = { @JoinColumn(name = "deputado_id") }, inverseJoinColumns = {
			@JoinColumn(name = "evento_id") })
	private java.util.List<Evento> eventos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}

	public java.util.List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(java.util.List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "Deputado [id= " + id + ", nomeCivil= " + nomeCivil + ", siglaPartido= " + siglaPartido + ", siglaUF= "
				+ siglaUF + ", eventos= " + eventos + "]";
	}
	
}