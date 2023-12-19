package ifsul.lp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ifsul.lp.entities.Evento;
import ifsul.lp.repository.EventoRepository;

@Service
public class EventoServices {
    
    @Autowired
		private EventoRepository eveRepo;
		
		public Evento criar(Evento evento) {

			if (eveRepo.existsById(evento.getId()) == false) {
            	return eveRepo.save(evento);
        	} else {
				return evento;
			}
			
		}

}