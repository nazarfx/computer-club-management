package org.example.herniklub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HERNI_STANICE", schema = "ST79048")
public class HerniStanice {
    @Id
    @Column(name = "ID_STANICE")
    private Integer idStanice;

    @Column(name = "CISLO_STANICE")
    private Integer cisloStanice;

    @Column(name = "HODINOVA_CENA")
    private Integer hodinovaCena;

    @Column(name = "STAV")
    private String stav;

    public HerniStanice() {}

    // Геттеры и сеттеры
    public Integer getIdStanice() { return idStanice; }
    public void setIdStanice(Integer idStanice) { this.idStanice = idStanice; }
    public Integer getCisloStanice() { return cisloStanice; }
    public void setCisloStanice(Integer cisloStanice) { this.cisloStanice = cisloStanice; }
    public Integer getHodinovaCena() { return hodinovaCena; }
    public void setHodinovaCena(Integer hodinovaCena) { this.hodinovaCena = hodinovaCena; }
    public String getStav() { return stav; }
    public void setStav(String stav) { this.stav = stav; }
}