package ifsul.lp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Evento")
public class Evento implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255, unique=true)
	private String descricaoTipo;
	
	@ManyToMany(mappedBy = "eventos", cascade = CascadeType.ALL)
	private List<Deputado> deputados = new ArrayList<>();
	
	public Evento () {}

	public Evento(Integer id, String descricaoTipo, List<Deputado> deputados) {
		super();
		this.id = id;
		this.descricaoTipo = descricaoTipo;
		this.deputados = deputados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	public List<Deputado> getDeputados() {
		return deputados;
	}

	public void setDeputados(List<Deputado> deputados) {
		this.deputados = deputados;
	}

	@Override
	public String toString() {
		return "Evento [id= " + id + ", descricaoTipo= " + descricaoTipo + ", deputados= " + deputados + "]";
	}
	
}