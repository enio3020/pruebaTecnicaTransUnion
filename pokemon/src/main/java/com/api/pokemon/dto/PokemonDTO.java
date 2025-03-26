package com.api.pokemon.dto;

public class PokemonDTO {
    private Long id;
    private String name;
    private String url;
    private String types;
    private String abilities;

    public PokemonDTO(Long id, String name, String url, String types, String abilities) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.types = types;
        this.abilities = abilities;
    }

    public PokemonDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTypes() {
        return this.types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getAbilities() {
        return this.abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

}
