package com.api.pokemon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TU_POKEMON_ABILITY")
public class PokemonAbility implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "POKABI_ID")
    @GeneratedValue(generator = "seqPokemonAbility")
    @SequenceGenerator(name = "seqPokemonAbility", sequenceName = "SEQ_POK_ABI", allocationSize = 1)
    private Long pokabiId;

    @JoinColumn(name = "FK_POKEMON", referencedColumnName = "POK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pokemon fkPokemon;

    @JoinColumn(name = "FK_ABILITY", referencedColumnName = "ABI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ability fkAbility;

    public PokemonAbility() {
    }

    public PokemonAbility(Long pokabiId, Pokemon fkPokemon, Ability fkAbility) {
        this.pokabiId = pokabiId;
        this.fkPokemon = fkPokemon;
        this.fkAbility = fkAbility;
    }

    public PokemonAbility(Long pokabiId) {
        this.pokabiId = pokabiId;
    }

    public Long getPokabiId() {
        return this.pokabiId;
    }

    public void setPokabiId(Long pokabiId) {
        this.pokabiId = pokabiId;
    }

    public Pokemon getFkPokemon() {
        return this.fkPokemon;
    }

    public void setFkPokemon(Pokemon fkPokemon) {
        this.fkPokemon = fkPokemon;
    }

    public Ability getFkAbility() {
        return this.fkAbility;
    }

    public void setFkAbility(Ability fkAbility) {
        this.fkAbility = fkAbility;
    }
}
