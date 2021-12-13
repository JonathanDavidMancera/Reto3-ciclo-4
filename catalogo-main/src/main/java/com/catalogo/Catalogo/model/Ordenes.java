package com.catalogo.Catalogo.model;

import java.util.Date;

import java.util.Map;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordenes")
public class Ordenes {
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private Usuarios salesMan;

    private Map<String, Productos> products;
    private Map<String, Integer> quantities;

    public Ordenes(Integer id, Date registerDay, String status, Usuarios salesMan, Map<String, Productos> products,
            Map<String, Integer> quantities) {
        this.id = id;
        this.registerDay = registerDay;
        this.status = status;
        this.salesMan = salesMan;
        this.products = products;
        this.quantities = quantities;
    }

    public Ordenes() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuarios getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(Usuarios salesMan) {
        this.salesMan = salesMan;
    }

    public Map<String, Productos> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Productos> products) {
        this.products = products;
    }

    public Map<String, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<String, Integer> quantities) {
        this.quantities = quantities;
    }

    

    

    
}
