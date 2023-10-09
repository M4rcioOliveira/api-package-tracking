package com.track.distance.service;

import com.track.distance.model.Endereco;
import com.track.distance.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public Endereco cadastrar(Endereco endereco) {

        return repository.save(endereco);

    }
}
