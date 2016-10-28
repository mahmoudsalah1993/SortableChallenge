package com.sortable.Models;

/**
 * Created by mahmoud on 27/10/16.
 */
public class Product {
    private String product_name;
    private String manufacturer;
    private String family;
    private  String model;
    private String announcedDate;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAnnouncedDate() {
        return announcedDate;
    }

    public void setAnnouncedDate(String announcedDate) {
        this.announcedDate = announcedDate;
    }
}
