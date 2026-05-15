package org.example.herniklub.repository;

import org.example.herniklub.model.Reservace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaceRepository extends JpaRepository<Reservace, Integer> {

    List<Reservace> findAllByIdZakaznik(Integer idZakaznik);
}