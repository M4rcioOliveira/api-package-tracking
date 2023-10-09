package com.track.distance.service.facade;


import com.track.distance.model.Cliente;
import com.track.distance.model.dto.PersistClienteRequestDTO;

public interface PersistClienteFacade {

    Cliente cadastrar(PersistClienteRequestDTO cliente);

}
