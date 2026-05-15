package org.example.herniklub.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "REZERVACI", schema = "ST79048")
public class Reservace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rez_gen")
    @SequenceGenerator(name = "rez_gen", sequenceName = "ST79048.REZERVACI_SEQ", allocationSize = 1)
    @Column(name = "ID_REZERVACE")
    private Integer id;

    @Column(name = "CAS_OD")
    private LocalDateTime casOd;

    @Column(name = "CAS_DO")
    private LocalDateTime casDo;

    @Column(name = "STAV_REZERVACE")
    private String stavRezervace;

    @Column(name = "ZAKAZNIK_ID_OSOBA")
    private Integer idZakaznik;

    @Column(name = "HERNI_STANICI_ID_STANICE")
    private Integer idStanice;

    @Column(name = "DATUM_REZERVACE")
    private LocalDateTime datumRezervace;

    @PrePersist
    protected void onCreate() {
        datumRezervace = LocalDateTime.now();
    }
}