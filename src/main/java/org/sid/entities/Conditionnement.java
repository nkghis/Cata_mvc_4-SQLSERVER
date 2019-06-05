package org.sid.entities;

import javax.persistence.*;

@Entity
@Table(name="conditionnements")

public class Conditionnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionnement_id;

    private String condionnement_nom;

    private int piece;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    public Conditionnement(){
        super();
    }

    public Conditionnement(String condionnement_nom, int piece, Produit produit) {
        this.condionnement_nom = condionnement_nom;
        this.piece = piece;
        this.produit = produit;
    }

    public Long getConditionnement_id() {
        return conditionnement_id;
    }

    public void setConditionnement_id(Long conditionnement_id) {
        this.conditionnement_id = conditionnement_id;
    }

    public String getCondionnement_nom() {
        return condionnement_nom;
    }

    public void setCondionnement_nom(String condionnement_nom) {
        this.condionnement_nom = condionnement_nom;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
