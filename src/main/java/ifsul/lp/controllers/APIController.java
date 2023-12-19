package ifsul.lp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import ifsul.lp.entities.*;
import ifsul.lp.services.*;
import ifsul.lp.DTO.*;

@RestController
public class APIController {

	@Autowired
	private APIServices apiService;

	@Autowired
	private DeputadoServices depService;

	@Autowired
	private EventoServices eventosService;

	@GetMapping("/clone")
	public List<DeputadoDTO> clone() {
		String data = apiService.getData();

		JSONObject jsnobject = new JSONObject(data);
		JSONArray jsonArray = jsnobject.getJSONArray("dados");
		ArrayList<Object> listdata = new ArrayList<Object>();

		for(int i = 0; i<10; i++) {
			Deputado dep = new Gson().fromJson(jsonArray.get(i).toString(), Deputado.class);
			depService.create(dep);
		}
		return depService.list();
	}

	@GetMapping("/listDeputados")
	public List<DeputadoDTO> getAllDeputados() {
		return depService.list();
	}

	@GetMapping("/getDeputadoById/{id}")
	public ResponseEntity<DeputadoDTO> getDeputadoById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(depService.getDeputadoById(id));
	}

	@PostMapping("/addEventToDeputado/{id}")
	public ResponseEntity<EventoDTO> addEventToDeputado(@PathVariable Long id, @RequestBody Evento evento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventosService.addEventToDeputado(id, evento));
	}

	@PutMapping("/editEvent/{id}")
	public ResponseEntity<EventoDTO> editEvent(@PathVariable Long id, @RequestBody Evento evento) {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.editEvent(id, evento));
	}

	@DeleteMapping("/deleteEvent/{id}")
	public void removeEvent(@PathVariable Long id) {
		eventosService.deleteEvent(id);
	}

	@GetMapping("/listEventos")
	public List<EventoDTO> listEventos() {
		String data = apiService.getDataEventos();
		List<Evento> eventosList = new ArrayList<>();

		JSONObject jsnobject = new JSONObject(data);
		JSONArray jsonArray = jsnobject.getJSONArray("dados");

		for(int i = 0; i<jsonArray.length(); i++) {
			Evento evento = new Gson().fromJson(jsonArray.get(i).toString(), Evento.class);

			//Verifica nome repetido
			List<Evento> eventosAtuais= eventosList.
					stream().
					filter(obj -> obj.getDescricaoTipo().equals(evento.getDescricaoTipo())).
					collect(Collectors.toList());
			if(eventosAtuais.isEmpty()) {
				eventosList.add(evento);
			}

		}

		return eventosList.
				stream().
				map(obj-> EventoDTO.builder().
						id(obj.getId()).
						descricaoTipo(obj.getDescricaoTipo()).
						build()).
				collect(Collectors.toList());
	}

	@GetMapping("/getEventosByDeputado/{id}")
	public List<EventoDTO> getEventosByDeputado(@PathVariable Long id) {
		return eventosService.listByDeputado(id).
				stream().
				map(obj-> EventoDTO.builder().
						id(obj.getId()).
						descricaoTipo(obj.getDescricaoTipo()).
						build()).
				collect(Collectors.toList());

	}

}
