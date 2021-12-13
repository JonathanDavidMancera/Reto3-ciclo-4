package com.catalogo.Catalogo.model;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productos")
public class Productos {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String material;
    private String presentacion;
    private String description;
    private Boolean availability;
    private Float price;
    private Integer quantity;
    private String photography;

    public Productos(String reference, String brand, String category, String material, String presentacion,
            String description, Boolean availability, Float price, Integer quantity, String photography) {
        this.reference = reference;
        this.brand = brand;
        this.category = category;
        this.material = material;
        this.presentacion = presentacion;
        this.description = description;
        this.availability = availability;
        this.price = price;
        this.quantity = quantity;
        this.photography = photography;
    }

    public Productos() {

    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotography() {
        return photography;
    }

    public void setPhotography(String photography) {
        this.photography = photography;
    }

    

    

    
}
