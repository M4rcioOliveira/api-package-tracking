package com.track.distance.model;

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
public class Encomenda {

    @JsonProperty("id_encomenda")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_remetente")
    private Cliente remetente;
    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private Cliente destinatario;
    @OneToMany(mappedBy = "encomenda")
    private List<Situacao> situacao;
    private Integer volume;
    private Integer peso;

}
