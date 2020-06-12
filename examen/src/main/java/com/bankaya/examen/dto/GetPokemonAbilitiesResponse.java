package com.bankaya.examen.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ability", "isHidden", "slot"
})
@XmlRootElement(namespace="http://spring.io/guides/gs-producing-web-service", name = "getPokemonAbilitiesResponse")
public class GetPokemonAbilitiesResponse {

    @XmlElement(required = true)
    protected Ability ability;

    @XmlElement(required = true)
    protected boolean isHidden;

    @XmlElement(required = true)
    protected int slot;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}