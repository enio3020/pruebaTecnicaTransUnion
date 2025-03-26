package com.api.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilitiesDTO {

    private AbilityDTO ability;

    @JsonProperty("is_hidden")
    private Boolean isHidden;

    private Integer slot;

    public AbilitiesDTO() {
    }

    public AbilitiesDTO(AbilityDTO ability, Boolean isHidden, Integer slot) {
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public AbilityDTO getAbility() {
        return this.ability;
    }

    public void setAbility(AbilityDTO ability) {
        this.ability = ability;
    }

    public Boolean isIsHidden() {
        return this.isHidden;
    }

    public Boolean getIsHidden() {
        return this.isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return this.slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
