package com.track.distance.service;

import com.track.distance.model.Cliente;
import com.track.distance.model.exception.ClienteFoundException;
import com.track.distance.model.exception.ClienteNotFoundException;
import com.track.distance.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente cadastrar(Cliente cliente) {

        try {

            buscarPorCpfCnpj(cliente.getCpfCnpj());

            throw new ClienteFoundException("O cliente " + cliente.getCpfCnpj() + " já existe na base de dados.");

        } catch (ClienteNotFoundException e) {

            return repository.save(cliente);

        }

    }

    @Override
    public Cliente buscarPorCpfCnpj(String cpfCnpj) {

        return repository.findByCpfCnpj(cpfCnpj).orElseThrow(
                () -> new ClienteNotFoundException("Cliente " + cpfCnpj + " não foi encontrado.")
        );

    }
}
