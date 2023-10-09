package com.track.distance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Cliente {

    @JsonProperty("id_cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String nome;
    @Column(unique = true)
    private String cpfCnpj;
    private String email;
    private String telefone;
    @OneToOne
    private Endereco endereco;
    @JsonIgnore
    @OneToMany(mappedBy = "remetente")
    private List<Encomenda> encomendasEnviadas;
    @JsonIgnore
    @OneToMany(mappedBy = "destinatario")
    private List<Encomenda> encomendasRecebidas;
}
