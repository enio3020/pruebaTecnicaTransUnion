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
@Table(name = "TU_POKEMON_TYPE")
public class PokemonType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "POKTYP_ID")
    @GeneratedValue(generator = "seqPokemonType")
    @SequenceGenerator(name = "seqPokemonType", sequenceName = "SEQ_POK_TYP", allocationSize = 1)
    private Long poktypId;

    @JoinColumn(name = "FK_POKEMON", referencedColumnName = "POK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pokemon fkPokemon;

    @JoinColumn(name = "FK_TYPE", referencedColumnName = "TYP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Type fkType;

    public PokemonType() {
    }

    public PokemonType(Long poktypId) {
        this.poktypId = poktypId;
    }

    public PokemonType(Long poktypId, Pokemon fkPokemon, Type fkType) {
        this.poktypId = poktypId;
        this.fkPokemon = fkPokemon;
        this.fkType = fkType;
    }

    public Long getPoktypId() {
        return this.poktypId;
    }

    public void setPoktypId(Long poktypId) {
        this.poktypId = poktypId;
    }

    public Pokemon getFkPokemon() {
        return this.fkPokemon;
    }

    public void setFkPokemon(Pokemon fkPokemon) {
        this.fkPokemon = fkPokemon;
    }

    public Type getFkType() {
        return this.fkType;
    }

    public void setFkType(Type fkType) {
        this.fkType = fkType;
    }
}
