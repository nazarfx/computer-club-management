package org.example.herniklub.repository;

import org.example.herniklub.model.HerniStanice;
import org.example.herniklub.model.Reservace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaniceRepository extends JpaRepository<HerniStanice, Integer> {
}
