package com.api.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

    public Type findByTypName(String var);

}
