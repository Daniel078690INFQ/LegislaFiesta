package ifsul.lp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Getter
@Setter
public class Deputado {

	@Id
	private Long id;

	private String nome;

	private String siglaPartido;

	private String siglaUf;

	@ManyToMany
	@JoinTable(
			name = "inscricoes",
			joinColumns = @JoinColumn(name = "deputado_id"),
			inverseJoinColumns = @JoinColumn(name = "evento_id"))
	private List<Evento> eventosList;

	public void adicionarEvento(Evento evento) {
		this.eventosList.add(evento);
		evento.getDeputadosList().add(this);
	}

}
