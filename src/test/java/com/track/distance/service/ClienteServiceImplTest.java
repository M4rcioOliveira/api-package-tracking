package com.track.distance.service;

import com.track.distance.model.Cliente;
import com.track.distance.model.Endereco;
import com.track.distance.model.exception.ClienteFoundException;
import com.track.distance.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

public class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCadastrarSuccess(){

        Cliente clienteMock = Cliente.builder().nome("Marcio").cpfCnpj("00000000000")
                .email("emeail@teste.com").telefone("(61)94002-8922").id(UUID.randomUUID())
                .endereco(new Endereco(UUID.randomUUID(), "2", "rua das graças", "pinhal", "Terezinha", "72855-084")).build();

        Mockito.when(clienteRepository.save(clienteMock)).thenReturn(clienteMock);

        Cliente clienteCadastrado = clienteService.cadastrar(clienteMock);

        Mockito.verify(clienteRepository, Mockito.times(1)).save(clienteMock);

        Assertions.assertEquals(clienteMock, clienteCadastrado);

    }

    @Test
    public void testCadastrarFoundException(){

        Cliente clienteMock = Cliente.builder().nome("Marcio").cpfCnpj("12345678911")
                .email("emeail@teste.com").telefone("(61)94002-8922").id(UUID.randomUUID())
                .endereco(new Endereco(UUID.randomUUID(), "2", "rua das graças", "pinhal", "Terezinha", "72855-084")).build();


        Mockito.when(clienteRepository.findByCpfCnpj("12345678911")).thenReturn(Optional.ofNullable(clienteMock));


        Assertions.assertThrows(ClienteFoundException.class, () -> clienteService.cadastrar(clienteMock));
        Mockito.verify(clienteRepository, Mockito.never()).save(clienteMock);


    }


}
