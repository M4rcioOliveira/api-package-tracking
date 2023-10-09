package com.track.distance.service;

import com.track.distance.model.Situacao;
import com.track.distance.model.exception.SituacaoNotFoudException;
import com.track.distance.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SituacaoServiceImpl implements SituacaoService {

    @Autowired
    private SituacaoRepository repository;

    @Override
    public Situacao cadastrar(Situacao situacao) {

        return repository.save(situacao);

    }

    @Override
    public Situacao atualizar(Situacao situacao) {
        return null;
    }

    @Override
    public Situacao buscarPorID(UUID id) {

        return repository.findById(id).orElseThrow(
                () -> new SituacaoNotFoudException("Situacao " + id + " não encontrada."));

    }
}
