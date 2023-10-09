package com.track.distance.service;

import com.track.distance.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService {
    Endereco cadastrar(Endereco endereco);

}
