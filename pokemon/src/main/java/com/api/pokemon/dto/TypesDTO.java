package com.api.pokemon.dto;

public class TypesDTO {

    private TypeDTO type;

    private Integer slot;

    public TypesDTO() {
    }

    public TypesDTO(TypeDTO type, Integer slot) {
        this.type = type;
        this.slot = slot;
    }

    public TypeDTO getType() {
        return this.type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public Integer getSlot() {
        return this.slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
