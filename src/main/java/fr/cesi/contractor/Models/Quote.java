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

    public Quote() { }

    public Quote(String object, String state, float totalCost, float totalPrice, Date created_at, Date updated_at, boolean isDeleted, int _v, Customer customer, Project project) {
        this.object = object;
        this.state = state;
        this.totalCost = totalCost;
        this.totalPrice = totalPrice;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.isDeleted = isDeleted;
        this._v = _v;
        this.customer = customer;
        this.project = project;
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

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
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
