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
@Table(name = "TU_TYPE")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TYP_ID")
    @GeneratedValue(generator = "seqType")
    @SequenceGenerator(name = "seqType", sequenceName = "SEQ_TYPE", allocationSize = 1)
    private Long typId;

    private String typName;

    private String typUrl;

    private Integer typSlot;

    public Type() {
    }

    public Type(Long typId) {
        this.typId = typId;
    }

    public Type(String typName, String typUrl, Integer typSlot) {
        this.typName = typName;
        this.typUrl = typUrl;
        this.typSlot = typSlot;
    }

    public Long getTypId() {
        return this.typId;
    }

    public void setTypId(Long typId) {
        this.typId = typId;
    }

    public String getTypName() {
        return this.typName;
    }

    public void setTypName(String typName) {
        this.typName = typName;
    }

    public String getTypUrl() {
        return this.typUrl;
    }

    public void setTypUrl(String typUrl) {
        this.typUrl = typUrl;
    }

    public Integer getTypSlot() {
        return this.typSlot;
    }

    public void setTypSlot(Integer typSlot) {
        this.typSlot = typSlot;
    }
}
