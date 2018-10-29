package entity;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String firm;
    private String model;
    private String purpose;
    private BigDecimal price;
    private String picture;

    public Product(int id, String firm, String model, String purpose, BigDecimal price, String picture) {
        this.firm = firm;
        this.model = model;
        this.purpose = purpose;
        this.price = price;
        this.picture = picture;
        this.id = id;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return id + " " + firm;
    }

    @Override
    public boolean equals(Object obj) {
       Product product = (Product) obj;


        return (product.getId() == id && product.getFirm().equals(firm ) && product.getPrice().equals(price) );
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
