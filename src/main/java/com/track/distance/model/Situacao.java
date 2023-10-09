package com.track.distance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.track.distance.enums.encomenda.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Situacao{

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private LocalDateTime data;
    private String Local;
    private String descricao;
    private String observacao;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_encomenda")
    private Encomenda encomenda;

}
