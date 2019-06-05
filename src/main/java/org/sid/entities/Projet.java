package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "projets")
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projet_id;
    private String Projet_nom;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

  /*  @ManyToMany
    @JoinTable(name="produit_projet", joinColumns = @JoinColumn(name = "produitId" ), inverseJoinColumns = @JoinColumn(name="projetId"))
    private Collection<Produit> produits;
    */
    @OneToMany(mappedBy = "projet")
    private Set<ProduitProjet> produitProjets;

    @OneToMany(mappedBy = "projet")
    private  Collection<Operation> operations;


    public Projet(){
        super();
    }




    public Projet(String projet_nom) {
        Projet_nom = projet_nom;
    }

    public Projet(String projet_nom, Client client) {
        Projet_nom = projet_nom;
        this.client = client;
    }

    public Long getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(Long projet_id) {
        this.projet_id = projet_id;
    }

    public String getProjet_nom() {
        return Projet_nom;
    }

    public void setProjet_nom(String projet_nom) {
        Projet_nom = projet_nom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ProduitProjet> getProduitProjets() {
        return produitProjets;
    }

    public void setProduitProjets(Set<ProduitProjet> produitProjets) {
        this.produitProjets = produitProjets;
    }

    /*public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }*/
}


