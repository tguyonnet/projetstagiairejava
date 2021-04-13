package fr.cesi.contractor.Models;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer _id;
    private String name;
    @ManyToOne
    private Customer customer;
    private String address;
    private Integer postCode;
    private String city;
    private Date dateBeginSite;
    private String state;
    private Boolean isDeleted;
    private Integer _v;
    private Date created_at;
    private Date updated_at;

    public Project() {
    }

    public Project(String name, Customer customer, String address, Integer postCode, String city, Date dateBeginSite, String state, Boolean isDeleted, Integer _v, Date created_at, Date updated_at) {
        this.name = name;
        this.customer = customer;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.dateBeginSite = dateBeginSite;
        this.state = state;
        this.isDeleted = isDeleted;
        this._v = _v;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateBeginSite() {
        return dateBeginSite;
    }

    public void setDateBeginSite(Date dateBeginSite) {
        this.dateBeginSite = dateBeginSite;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Integer get_v() {
        return _v;
    }

    public void set_v(Integer _v) {
        this._v = _v;
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
}
