package ifsul.lp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Evento {

	@Id
	private Long id;

	private String descricaoTipo;

	@ManyToMany(mappedBy = "eventosList")
	private List<Deputado> deputadosList;
}
