package fr.cesi.contractor.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int _id;

}
