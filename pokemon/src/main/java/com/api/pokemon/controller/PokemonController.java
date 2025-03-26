package com.api.pokemon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemon.dto.AbilitiesDTO;
import com.api.pokemon.dto.CargarPokemonDTO;
import com.api.pokemon.dto.PokemonDTO;
import com.api.pokemon.dto.TypesDTO;
import com.api.pokemon.entity.Ability;
import com.api.pokemon.entity.Pokemon;
import com.api.pokemon.entity.PokemonAbility;
import com.api.pokemon.entity.PokemonType;
import com.api.pokemon.entity.Type;
import com.api.pokemon.repository.ReporteRepository;
import com.api.pokemon.service.ApiPokemonService;
import com.api.pokemon.service.PokemonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    ReporteRepository reporteRepository;

    @PostMapping(value = "/iniciarCarga")
    public ResponseEntity savePokemon(@RequestBody CargarPokemonDTO var)
            throws JSONException, JsonMappingException, JsonProcessingException {

        return new ResponseEntity<String>(pokemonService.cargarModelo(var).toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/reporte")
    public ResponseEntity<List<PokemonDTO>> reporte(@RequestParam String nameAbility, @RequestParam String namePokemon,
            @RequestParam String nameType) {

        return new ResponseEntity<List<PokemonDTO>>(
                reporteRepository.getPokemonReport(namePokemon, nameType, nameAbility), HttpStatus.OK);
    }

}
