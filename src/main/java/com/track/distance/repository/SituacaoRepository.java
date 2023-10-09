package com.track.distance.repository;

import com.track.distance.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, UUID> {

}
