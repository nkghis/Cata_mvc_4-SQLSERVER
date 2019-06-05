package org.sid.entities;




import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produit_id;
    private String produit_nom;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<Conditionnement> conditionnements;

    /*@ManyToMany(mappedBy = "produits")
    private Collection<Projet> projets;*/


    @OneToMany(mappedBy = "produit")
    private Set<ProduitProjet> produitProjets = new HashSet<>();

    @OneToMany(mappedBy = "myproduit", fetch = FetchType.LAZY)
    private Collection<Operation> operations;



    public Produit(){
        super();
    }

    public Produit(String produit_nom) {
        this.produit_nom = produit_nom;
    }

    public Long getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(Long produit_id) {
        this.produit_id = produit_id;
    }

    public String getProduit_nom() {
        return produit_nom;
    }

    public void setProduit_nom(String produit_nom) {
        this.produit_nom = produit_nom;
    }

    public Set<ProduitProjet> getProduitProjets() {
        return produitProjets;
    }

    public void setProduitProjets(Set<ProduitProjet> produitProjets) {
        this.produitProjets = produitProjets;
    }

    public Collection<Conditionnement> getConditionnements() {
        return conditionnements;
    }

    public void setConditionnements(Collection<Conditionnement> conditionnements) {
        this.conditionnements = conditionnements;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }


   /* public Collection<Projet> getProjets() {
        return projets;
    }

    public void setProjets(Collection<Projet> projets) {
        this.projets = projets;
    }*/
}
