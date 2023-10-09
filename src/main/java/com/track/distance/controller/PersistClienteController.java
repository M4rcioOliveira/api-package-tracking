package com.track.distance.controller;

import com.track.distance.model.Cliente;
import com.track.distance.model.dto.PersistClienteRequestDTO;
import com.track.distance.service.facade.PersistClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class PersistClienteController {

    @Autowired
    private PersistClienteFacade persistClienteFacade;
    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cliente(@RequestBody PersistClienteRequestDTO clienteRequest){

        return new ResponseEntity<>(persistClienteFacade.cadastrar(clienteRequest), HttpStatus.CREATED);

    }

}
