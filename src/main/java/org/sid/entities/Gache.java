package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "gaches")
@DiscriminatorValue("3")
public class Gache extends Operation {
    public Gache() {
    }

    public Gache(int operation_qte, Date operation_date, int user_id, Projet projet, Produit myproduit) {
        super(operation_qte, operation_date, user_id, projet, myproduit);
    }
}
