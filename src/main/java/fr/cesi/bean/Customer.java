package fr.cesi.bean;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nom;
    private String firstName;
    private String email;
    private Integer phoneNumber;
    private String sexe;
    private String typeCustomer;
    private Boolean isDeleted;
    private String _v;
}