package com.api.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    public Pokemon findByPokName(String var);

}
