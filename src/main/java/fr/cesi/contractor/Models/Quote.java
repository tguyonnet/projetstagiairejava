package fr.cesi.contractor.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int _id;

    private String object;
    private String state;
    private float totalCost;
    private float totalPrice;
    private Date created_at;
    private Date updated_at;
    private boolean isDeleted;
    private int _v;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Project project;

    public Quote() {
        this.init();
    }

    public Quote(String object, float totalCost, float totalPrice, Customer customer, Project project) {
        this.object = object;
        this.totalCost = totalCost;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.project = project;
        this.init();
    }

    private void init() {
        this.setState("En attente");
        this.setCreated_at();
        this.setUpdated_at();
        this.setDeleted(false);
        this.set_v(1);
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at() {
        this.created_at = new Date();
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at() {
        this.updated_at = new Date();
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int get_v() {
        return _v;
    }

    public void set_v(int _v) {
        this._v = _v;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
