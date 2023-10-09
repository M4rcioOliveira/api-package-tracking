package com.track.distance.repository;


import com.track.distance.model.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, UUID> {

    @Query("SELECT e FROM Encomenda e WHERE e.destinatario.cpfCnpj = :cpfCnpjDestinatario")
    List<Encomenda> findByCpfCnpjDestinatario(String cpfCnpjDestinatario);

}
