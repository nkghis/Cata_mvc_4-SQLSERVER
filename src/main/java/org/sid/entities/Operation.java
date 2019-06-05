package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "operations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operation_id;
    private int operation_qte;
    private Date operation_date;
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "projetId")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit myproduit;



    public Operation(){
        super();
    }

    public Operation(int operation_qte, Date operation_date, int user_id, Projet projet, Produit myproduit) {
        this.operation_qte = operation_qte;
        this.operation_date = operation_date;
        this.user_id = user_id;
        this.projet = projet;
        this.myproduit = myproduit;
    }

    public Long getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Long operation_id) {
        this.operation_id = operation_id;
    }

    public int getOperation_qte() {
        return operation_qte;
    }

    public void setOperation_qte(int operation_qte) {
        this.operation_qte = operation_qte;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Produit getMyproduit() {
        return myproduit;
    }

    public void setMyproduit(Produit myproduit) {
        this.myproduit = myproduit;
    }

}
