package com.track.distance.service.facade;

import com.track.distance.enums.encomenda.Tipo;
import com.track.distance.model.Cliente;
import com.track.distance.model.Encomenda;
import com.track.distance.model.Situacao;
import com.track.distance.model.dto.PersistEncomendaRequestDTO;
import com.track.distance.service.ClienteService;
import com.track.distance.service.EncomendaService;
import com.track.distance.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersistEncomendaImplFacade implements PersistEncomendaFacade {

    @Autowired
    private SituacaoService situacaoService;

    @Autowired
    private EncomendaService encomendaService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public Situacao cadastrar(PersistEncomendaRequestDTO request) {

        Cliente remetente = clienteService.buscarPorCpfCnpj(request.cpfCnpjRemetente());
        Cliente destinatario = clienteService.buscarPorCpfCnpj(request.cpfCnpjDestinatario());

        Encomenda encomenda = encomendaService.cadastrar(buildEncomenda( destinatario, remetente, request.peso(), request.volume()));
        Situacao situacao = situacaoService.cadastrar(buildSituacao(encomenda));

        return situacao;

    }

    public Situacao buildSituacao(Encomenda encomenda) {

        return Situacao.builder().tipo(Tipo.REMESSA_CRIADA).Local("Brasilia - DF").descricao("Remessa criada.")
                .data(LocalDateTime.now()).encomenda(encomenda).observacao("").build();

    };

    public Encomenda buildEncomenda(Cliente destinatario, Cliente remetente, int peso, int volume){

        return Encomenda.builder().destinatario(destinatario).remetente(remetente)
                .peso(peso).volume(volume).build();

    }


}
