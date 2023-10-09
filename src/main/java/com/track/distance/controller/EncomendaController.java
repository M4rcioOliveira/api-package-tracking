package com.track.distance.controller;


import com.track.distance.model.Encomenda;
import com.track.distance.model.dto.EncomendaResponseDTO;
import com.track.distance.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/encomenda")
public class EncomendaController {

    @Autowired
    private EncomendaService service;

    @GetMapping("/buscar")
    public List<EncomendaResponseDTO> buscar(@RequestParam String cpfCnpjDestinatario){

        return  service.buscar(cpfCnpjDestinatario);

    }

}
