package com.api.pokemon.dto;

public class CargarPokemonDTO {

    private Integer offset;

    private Integer limit;

    public CargarPokemonDTO() {
    }

    public CargarPokemonDTO(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
