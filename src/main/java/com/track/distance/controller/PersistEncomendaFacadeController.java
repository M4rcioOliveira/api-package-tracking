package com.track.distance.controller;

import com.track.distance.model.Situacao;
import com.track.distance.model.dto.PersistEncomendaRequestDTO;
import com.track.distance.service.facade.PersistEncomendaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encomenda")
public class PersistEncomendaFacadeController {

    @Autowired
    private PersistEncomendaFacade persistEncomendaFacade;

    @PostMapping("/cadastrar")
    private Situacao cadastrar(@RequestBody PersistEncomendaRequestDTO request){

        return  persistEncomendaFacade.cadastrar(request);

    }

}
