package org.example.herniklub.controller;

import org.example.herniklub.model.Reservace;
import org.example.herniklub.repository.ReservaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservaceController {

    @Autowired
    private ReservaceRepository repository;


    @GetMapping
    public List<Reservace> getMyReservations() {
        // Пока что будем считать, что ты — это пользователь с ID 1
        return repository.findAllByIdZakaznik(1);
    }

    @PostMapping
    public Reservace createReservation(@RequestBody Reservace reservace) {
        // Здесь можно будет добавить проверку времени
        return repository.save(reservace);
    }
}
