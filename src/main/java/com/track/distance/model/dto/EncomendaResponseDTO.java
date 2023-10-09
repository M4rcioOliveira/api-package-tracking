package com.track.distance.model.dto;

import com.track.distance.model.Situacao;

import java.util.List;
import java.util.UUID;

public record EncomendaResponseDTO (UUID cod_rastreio, String remetente, String cidade, List<Situacao> situacao, int peso, int volume){
}
