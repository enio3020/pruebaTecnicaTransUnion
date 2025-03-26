package com.api.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entity.Ability;
import com.api.pokemon.entity.Pokemon;
import com.api.pokemon.entity.PokemonAbility;

public interface PokemonAbilityRepository extends JpaRepository<PokemonAbility, Long> {

    public PokemonAbility findByFkPokemonAndFkAbility(Pokemon var, Ability var2);
}
