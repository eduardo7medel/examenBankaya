package com.bankaya.examen.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id","name","baseExperience","abilities","locationAreaEncounters","heldItems"})
@XmlRootElement(namespace="http://spring.io/guides/gs-producing-web-service", name = "getPokemonResponse")
public class GetPokemonResponse {

    @XmlElement(required = true)
    protected int id;

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected int baseExperience;

    @XmlElement(required = true)
    protected ArrayList<GetPokemonAbilitiesResponse> abilities;

    @XmlElement(required = true)
    protected ArrayList<HeldItemsResponse> heldItems;

    @XmlElement(required = true)
    protected String locationAreaEncounters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public ArrayList<GetPokemonAbilitiesResponse> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<GetPokemonAbilitiesResponse> abilities) {
        this.abilities = abilities;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public ArrayList<HeldItemsResponse> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(ArrayList<HeldItemsResponse> heldItems) {
        this.heldItems = heldItems;
    }
}
