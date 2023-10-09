package com.track.distance.service.facade;


import com.track.distance.model.Situacao;
import com.track.distance.model.dto.PersistEncomendaRequestDTO;

public interface PersistEncomendaFacade {

    Situacao cadastrar(PersistEncomendaRequestDTO encomenda);

}
