package com.api.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entity.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Long> {

    public Ability findByAbiName(String var);

}
