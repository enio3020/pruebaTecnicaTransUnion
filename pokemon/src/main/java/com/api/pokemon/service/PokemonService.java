package com.api.pokemon.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.api.pokemon.dto.AbilitiesDTO;
import com.api.pokemon.dto.CargarPokemonDTO;
import com.api.pokemon.dto.TypesDTO;
import com.api.pokemon.entity.Ability;
import com.api.pokemon.entity.Pokemon;
import com.api.pokemon.entity.PokemonAbility;
import com.api.pokemon.entity.PokemonType;
import com.api.pokemon.entity.Type;
import com.api.pokemon.exception.BadRequestException;
import com.api.pokemon.repository.AbilityRepository;
import com.api.pokemon.repository.PokemonAbilityRepository;
import com.api.pokemon.repository.PokemonRepository;
import com.api.pokemon.repository.PokemonTypeRepository;
import com.api.pokemon.repository.TypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PokemonService {

    final String uri = "https://pokeapi.co/api/v2/pokemon?offset={offset}&limit={limit}";

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    ApiPokemonService apiPokemonService;

    @Autowired
    AbilityRepository abilityRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    PokemonAbilityRepository pokemonAbilityRepository;

    @Autowired
    PokemonTypeRepository pokemonTypeRepository;

    public JSONObject cargarModelo(CargarPokemonDTO var)
            throws JSONException, JsonMappingException, JsonProcessingException {

        String url = uri.replace("{offset}", var.getOffset().toString()).replace("{limit}", var.getLimit().toString());

        JSONObject json = apiPokemonService.getApiPokemon(url);

        ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
        ObjectMapper objectMapper = new ObjectMapper();

        pokemon = objectMapper.readValue(json.getJSONArray("results").toString(),
                new TypeReference<ArrayList<Pokemon>>() {
                });

        pokemon.forEach(x -> {
            Pokemon pokem = savePokemon(x);
            try {
                ArrayList<AbilitiesDTO> abilities = new ArrayList<AbilitiesDTO>();
                ArrayList<TypesDTO> types = new ArrayList<TypesDTO>();

                JSONObject xjson = apiPokemonService.getApiPokemon(x.getPokUrl());
                JSONArray ability = xjson.getJSONArray("abilities");
                JSONArray type = xjson.getJSONArray("types");

                abilities = objectMapper.readValue(ability.toString(),
                        new TypeReference<ArrayList<AbilitiesDTO>>() {
                        });

                types = objectMapper.readValue(type.toString(),
                        new TypeReference<ArrayList<TypesDTO>>() {
                        });

                types.forEach(k -> {
                    Type xtype = new Type(k.getType().getName(), k.getType().getUrl(), k.getSlot());
                    xtype = saveType(xtype);
                    PokemonType pokemonType = new PokemonType();
                    pokemonType.setFkPokemon(pokem);
                    pokemonType.setFkType(xtype);
                    savePokemonType(pokemonType);
                });

                abilities.forEach(j -> {
                    Ability xability = new Ability(j.getAbility().getName(), j.getAbility().getUrl(), j.getIsHidden(),
                            j.getSlot());
                    xability = saveAbility(xability);
                    PokemonAbility pokemonAbility = new PokemonAbility();
                    pokemonAbility.setFkAbility(xability);
                    pokemonAbility.setFkPokemon(pokem);
                    savePokemonAbility(pokemonAbility);
                });
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        return json;
    }

    public Pokemon savePokemon(Pokemon pokemon) {
        Pokemon pokem = pokemonRepository.findByPokName(pokemon.getPokName());

        if (pokem == null) {
            pokem = pokemonRepository.save(pokemon);
        }

        return pokem;
    }

    public Ability saveAbility(Ability ability) {
        Ability abi = abilityRepository.findByAbiName(ability.getAbiName());

        if (abi == null) {
            abi = abilityRepository.save(ability);
        }

        return abi;
    }

    public Type saveType(Type type) {
        Type typ = typeRepository.findByTypName(type.getTypName());

        if (typ == null) {
            typ = typeRepository.save(type);
        }

        return typ;
    }

    public PokemonAbility savePokemonAbility(PokemonAbility pokAbi) {
        PokemonAbility pokAb = pokemonAbilityRepository.findByFkPokemonAndFkAbility(pokAbi.getFkPokemon(),
                pokAbi.getFkAbility());

        if (pokAb == null) {
            pokAb = pokemonAbilityRepository.save(pokAbi);
        }

        return pokAb;
    }

    public PokemonType savePokemonType(PokemonType pokTyp) {
        PokemonType pokTy = pokemonTypeRepository.findByFkPokemonAndFkType(pokTyp.getFkPokemon(), pokTyp.getFkType());

        if (pokTy == null) {
            pokTy = pokemonTypeRepository.save(pokTyp);
        }

        return pokTy;
    }
}
