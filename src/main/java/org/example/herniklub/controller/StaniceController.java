package org.example.herniklub.controller;

import org.example.herniklub.model.HerniStanice;
import org.example.herniklub.repository.StaniceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "http://localhost:63343")
public class StaniceController {

    @Autowired
    private StaniceRepository repository;

    @GetMapping
    public List<HerniStanice> getAllStations() {
        return repository.findAll();
    }

@PatchMapping("/{id}/reserve")
@Transactional
@CrossOrigin(origins = "*") // Чтобы WebStorm мог достучаться
    public HerniStanice reserveStation(@PathVariable Integer id) {
        HerniStanice station = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        station.setStav("OBSAZENO"); // Меняем статус
        return repository.save(station); // Сохраняем в Oracle
    }

    @PatchMapping("/{id}/cancel")
    @Transactional
    public HerniStanice cancelReservation(@PathVariable Integer id) {
        HerniStanice station = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        station.setStav("VOLNO"); // Возвращаем статус, который разрешен базой
        return repository.save(station);
    }
}
