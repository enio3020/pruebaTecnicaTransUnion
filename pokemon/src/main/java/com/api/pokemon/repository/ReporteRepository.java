package com.api.pokemon.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.api.pokemon.dto.PokemonDTO;

@Repository
public class ReporteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PokemonDTO> getPokemonReport(String name, String type, String ability) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("get_pokemon_report");

        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, void.class, ParameterMode.REF_CURSOR);

        query.setParameter(1, name);
        query.setParameter(2, type);
        query.setParameter(3, ability);

        query.execute();
        List<Object[]> results = query.getResultList();

        return results.stream().map(row -> new PokemonDTO(
                ((BigDecimal) row[0]).longValue(), // ID
                (String) row[1], // Name
                (String) row[2], // URL
                (String) row[3], // Types
                (String) row[4] // Abilities
        )).collect(Collectors.toList());
    }
}
