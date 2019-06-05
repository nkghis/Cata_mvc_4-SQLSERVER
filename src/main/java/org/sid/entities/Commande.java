package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "commandes")
@DiscriminatorValue("1")
public class Commande extends  Operation {


    public Commande() {
    }

    public Commande(int operation_qte, Date operation_date, int user_id, Projet projet, Produit myproduit) {
        super(operation_qte, operation_date, user_id, projet, myproduit);
    }
}
