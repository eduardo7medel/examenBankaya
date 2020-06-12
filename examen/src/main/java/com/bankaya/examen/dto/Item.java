package com.bankaya.examen.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
        "name",
        "url"
})
public class Item {

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected String url;

    public Item(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
