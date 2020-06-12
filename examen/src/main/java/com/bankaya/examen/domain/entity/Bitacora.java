package com.bankaya.examen.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

import java.util.Date;

@Entity
@Table(name = "bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "request")
    private String request;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ip")
    private String ip;

    @Basic(optional = false)
    @NotNull
    @Column(name = "metodo")
    private String metodo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private Date fecha;

    public Bitacora(Integer id, String request, String ip, String metodo, Date fecha) {
        this.id = id;
        this.request = request;
        this.ip = ip;
        this.metodo = metodo;
        this.fecha = fecha;
    }

    public Bitacora(String request, String ip, String metodo, Date fecha) {
        this.request = request;
        this.ip = ip;
        this.metodo = metodo;
        this.fecha = fecha;
    }

    public Bitacora() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
