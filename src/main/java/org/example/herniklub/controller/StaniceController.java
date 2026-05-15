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
@CrossOrigin(origins = "*")
    public HerniStanice reserveStation(@PathVariable Integer id) {
        HerniStanice station = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        station.setStav("OBSAZENO");
        return repository.save(station);
    }

    @PatchMapping("/{id}/cancel")
    @Transactional
    public HerniStanice cancelReservation(@PathVariable Integer id) {
        HerniStanice station = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found"));

        station.setStav("VOLNO");
        return repository.save(station);
    }
}
