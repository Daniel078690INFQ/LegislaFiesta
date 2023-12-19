package ifsul.lp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ifsul.lp.entities.*;
import ifsul.lp.repository.*;
import ifsul.lp.DTO.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServices {

	@Autowired
	private EventoRepository eventoRepo;
	@Autowired
	private DeputadoRepository depRepo;

	public List<Evento> listByDeputado(Long id) {
		return eventoRepo.findAllByDeputadosListId(id);
	}


	public EventoDTO addEventToDeputado(Long id, Evento evento) {
		Deputado deputado = depRepo.findById(id).get();
		evento.setDeputadosList(new ArrayList<>());

		Evento novoEvento = eventoRepo.findById(evento.getId()).orElse(evento);
		deputado.adicionarEvento(novoEvento);

		eventoRepo.save(novoEvento);
		return EventoDTO.builder().
				id(novoEvento.getId()).
				descricaoTipo(novoEvento.getDescricaoTipo()).
				build();
	}

	public EventoDTO editEvent(Long id, Evento request) {
		Evento evento = eventoRepo.findById(id).get();
		evento.setDeputadosList(new ArrayList<>());

		evento.setDescricaoTipo(request.getDescricaoTipo());

		eventoRepo.save(evento);
		return EventoDTO.builder().
				id(evento.getId()).
				descricaoTipo(evento.getDescricaoTipo()).
				build();
	}

	public void deleteEvent(Long id) {
		Evento evento = eventoRepo.findById(id).get();

		eventoRepo.deleteById(id);
	}

}