package com.track.distance.model.dto;

public record PersistClienteRequestDTO(String nome, String email, String telefone, String cpfCnpj, PersistEnderecoRequestDTO endereco) {}
