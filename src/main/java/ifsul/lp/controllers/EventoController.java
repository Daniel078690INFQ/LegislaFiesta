package ifsul.lp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ifsul.lp.services.*;
import ifsul.lp.entities.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoServices eveSer;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Evento cadastrar(@RequestBody Evento evento) {
        return eveSer.criar(evento);
    }

}
