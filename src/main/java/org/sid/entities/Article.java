package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String designation;
    private double prix;
    private int quantite;


    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Article(String designation, double prix, int quantite) {
        super();
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public double getPrix() {
        return prix;
    }


    public void setPrix(double prix) {
        this.prix = prix;
    }


    public int getQuantite() {
        return quantite;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


}
