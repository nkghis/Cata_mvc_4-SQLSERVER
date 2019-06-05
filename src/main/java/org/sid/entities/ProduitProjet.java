package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "produits_projets")
public class ProduitProjet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Projet projet;

    @Id
    @ManyToOne
    @JoinColumn
    private Produit produit;

    private int stock_qte;

    private Date stock_date;

    public ProduitProjet() {
        super();
    }

    public ProduitProjet(Projet projet, Produit produit, int stock_qte, Date stock_date) {
        this.projet = projet;
        this.produit = produit;
        this.stock_qte = stock_qte;
        this.stock_date = stock_date;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getStock_qte() {
        return stock_qte;
    }

    public void setStock_qte(int stock_qte) {
        this.stock_qte = stock_qte;
    }

    public Date getStock_date() {
        return stock_date;
    }

    public void setStock_date(Date stock_date) {
        this.stock_date = stock_date;
    }


}
