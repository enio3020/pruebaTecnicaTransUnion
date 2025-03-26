package com.api.pokemon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TU_POKEMON")
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "POK_ID")
    @GeneratedValue(generator = "seqPokemon")
    @SequenceGenerator(name = "seqPokemon", sequenceName = "SEQ_POKEMON", allocationSize = 1)
    private Long pokId;

    @JsonProperty("name")
    private String pokName;

    @JsonProperty("url")
    private String pokUrl;

    public Pokemon() {
    }

    public Pokemon(Long pokId) {
        this.pokId = pokId;
    }

    public Pokemon(Long pokId, String pokName, String pokUrl) {
        this.pokId = pokId;
        this.pokName = pokName;
        this.pokUrl = pokUrl;
    }

    public Long getPokId() {
        return this.pokId;
    }

    public void setPokId(Long pokId) {
        this.pokId = pokId;
    }

    public String getPokName() {
        return this.pokName;
    }

    public void setPokName(String pokName) {
        this.pokName = pokName;
    }

    public String getPokUrl() {
        return this.pokUrl;
    }

    public void setPokUrl(String pokUrl) {
        this.pokUrl = pokUrl;
    }

}
