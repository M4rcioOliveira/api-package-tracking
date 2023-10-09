package com.track.distance.service;

import com.track.distance.model.Situacao;

import java.util.UUID;

public interface SituacaoService {

    Situacao cadastrar(Situacao situacao);
    Situacao atualizar(Situacao situacao);
    Situacao buscarPorID(UUID id);
}
