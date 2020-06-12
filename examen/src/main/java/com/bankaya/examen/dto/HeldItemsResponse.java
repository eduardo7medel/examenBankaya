package com.bankaya.examen.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "item", "versionDetails"
})
@XmlRootElement(namespace="http://spring.io/guides/gs-producing-web-service", name = "getPokemonHeldItemsResponse")
public class HeldItemsResponse {

    @XmlElement(required = true)
    protected Item item;

    @XmlElement(required = true)
    protected ArrayList<VersionDetails> versionDetails;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<VersionDetails> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(ArrayList<VersionDetails> versionDetails) {
        this.versionDetails = versionDetails;
    }
}
