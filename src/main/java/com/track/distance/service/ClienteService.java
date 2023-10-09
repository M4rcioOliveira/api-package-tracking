package com.track.distance.service;

import com.track.distance.model.Cliente;

public interface ClienteService {
    Cliente cadastrar(Cliente cliente);

    Cliente buscarPorCpfCnpj(String cpfCnpj);
}
