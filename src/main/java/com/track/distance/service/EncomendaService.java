package com.track.distance.service;

import com.track.distance.model.Encomenda;
import com.track.distance.model.dto.EncomendaResponseDTO;

import java.util.List;
import java.util.UUID;

public interface EncomendaService {
    Encomenda cadastrar(Encomenda encomenda);

    List<EncomendaResponseDTO> buscar(String cpfCnpjDestinatario);

}
