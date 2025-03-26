package com.api.pokemon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TU_ABILITY")
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ABI_ID")
    @GeneratedValue(generator = "seqAbility")
    @SequenceGenerator(name = "seqAbility", sequenceName = "SEQ_ABILITY", allocationSize = 1)
    private Long abiId;

    private String abiName;

    private String abiUrl;

    private Boolean abiIsHidden;

    private Integer abiSlot;

    public Ability() {
    }

    public Ability(Long abiId) {
        this.abiId = abiId;
    }

    public Ability(String abiName, String abiUrl, Boolean abiIsHidden, Integer abiSlot) {
        this.abiName = abiName;
        this.abiUrl = abiUrl;
        this.abiIsHidden = abiIsHidden;
        this.abiSlot = abiSlot;
    }

    public Long getAbiId() {
        return this.abiId;
    }

    public void setAbiId(Long abiId) {
        this.abiId = abiId;
    }

    public String getAbiName() {
        return this.abiName;
    }

    public void setAbiName(String abiName) {
        this.abiName = abiName;
    }

    public String getAbiUrl() {
        return this.abiUrl;
    }

    public void setAbiUrl(String abiUrl) {
        this.abiUrl = abiUrl;
    }

    public Boolean isAbiIsHidden() {
        return this.abiIsHidden;
    }

    public Boolean getAbiIsHidden() {
        return this.abiIsHidden;
    }

    public void setAbiIsHidden(Boolean abiIsHidden) {
        this.abiIsHidden = abiIsHidden;
    }

    public Integer getAbiSlot() {
        return this.abiSlot;
    }

    public void setAbiSlot(Integer abiSlot) {
        this.abiSlot = abiSlot;
    }
}
