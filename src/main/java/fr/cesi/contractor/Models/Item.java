package fr.cesi.contractor.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer _id;

    private String designation;
    private int quantity;
    private String usageUnit;
    private float cost;
    private float price;


    public Item() {

    }

    public Item(String designation, int quantity, String usageUnit, float cost, float price) {
        this.designation = designation;
        this.quantity = quantity;
        this.usageUnit = usageUnit;
        this.cost = cost;
        this.price = price;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsageUnit() {
        return usageUnit;
    }

    public void setUsageUnit(String usageUnit) {
        this.usageUnit = usageUnit;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
