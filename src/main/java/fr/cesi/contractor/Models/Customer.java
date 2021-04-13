package fr.cesi.contractor.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nom;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String sexe;
    private String typeCustomer;
    private Boolean isDeleted;
    private String _v;
    private Date created_at;
    private Date updated_at;


    public Customer(String nom, String firstName, String email, String phoneNumber, String sexe, String typeCustomer, Boolean isDeleted, String _v, Date created_at, Date updated_at) {
        this.nom = nom;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sexe = sexe;
        this.typeCustomer = typeCustomer;
        this.isDeleted = isDeleted;
        this._v = _v;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public String get_v() {
        return _v;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void set_v(String _v) {
        this._v = _v;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
