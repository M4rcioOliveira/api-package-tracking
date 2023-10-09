package com.track.distance.service;

import com.track.distance.model.Encomenda;
import com.track.distance.model.dto.EncomendaResponseDTO;
import com.track.distance.model.exception.EncomendaNotFoundException;
import com.track.distance.repository.EncomendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EncomendaServiceImpl implements EncomendaService {

    @Autowired
    private EncomendaRepository repository;

    @Override
    public Encomenda cadastrar(Encomenda encomenda) {
        return repository.save(encomenda);
    }

    @Override
    public List<EncomendaResponseDTO> buscar(String cpfCnpjDestinatario) {

        List<EncomendaResponseDTO> encomendaResponse = new ArrayList<>();

        List<Encomenda> encomendas = repository.findByCpfCnpjDestinatario(cpfCnpjDestinatario);

        System.out.println("TAMANHO: " + encomendas.size());

        for (Encomenda encomenda : encomendas) {

            encomendaResponse.add(new EncomendaResponseDTO(encomenda.getId(), encomenda.getDestinatario().getNome(),
                    encomenda.getDestinatario().getEndereco().getCidade(), encomenda.getSituacao(),
                    encomenda.getPeso(), encomenda.getVolume()));

        }

        return encomendaResponse;

    }

}
