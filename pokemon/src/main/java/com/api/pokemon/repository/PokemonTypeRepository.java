package com.api.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entity.Pokemon;
import com.api.pokemon.entity.PokemonType;
import com.api.pokemon.entity.Type;

public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long> {

    public PokemonType findByFkPokemonAndFkType(Pokemon var, Type var2);

}
