package com.track.distance.model.dto;

import java.util.UUID;

public record PersistEncomendaRequestDTO(String cpfCnpjRemetente, String cpfCnpjDestinatario, Integer volume, Integer peso) {



}
