package com.bankaya.examen.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "out"
})
@XmlRootElement(name = "ping")
public class PingResponse {

    @XmlElement(required = true)
    private String out;

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
