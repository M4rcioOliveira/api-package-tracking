package com.track.distance.service.facade;

import com.track.distance.model.Cliente;
import com.track.distance.model.Endereco;
import com.track.distance.model.dto.PersistClienteRequestDTO;
import com.track.distance.service.ClienteService;
import com.track.distance.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistClienteFacadeImpl implements PersistClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Cliente cadastrar(PersistClienteRequestDTO clienteRequest) {


        Endereco endereco = enderecoService.cadastrar(Endereco.builder().numero(clienteRequest.endereco()
                .numero()).complemento(clienteRequest.endereco().complemento()).bairro(clienteRequest.endereco().bairro()).cep(clienteRequest.endereco().cep()).cidade(clienteRequest.endereco().cidade()).build());


        Cliente cliente = clienteService.cadastrar(Cliente.builder().email(clienteRequest.email())
                .nome(clienteRequest.nome()).telefone(clienteRequest.telefone()).cpfCnpj(clienteRequest.cpfCnpj()).endereco(endereco).build());

        return  cliente;

    }
}
