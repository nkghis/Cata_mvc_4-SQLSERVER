package org.sid.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @NotNull
    /*@Size(min = 1, message = "non vide")*/
    private String client_nom;

   @NotNull
   /* @Size(min = 8, max=12)*/
    private String contact;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Projet> projets;

    public Client(){
        super();
    }

    public Client(String client_nom, String contact) {
        this.client_nom = client_nom;
        this.contact = contact;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_nom() {
        return client_nom;
    }

    public void setClient_nom(String client_nom) {
        this.client_nom = client_nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Collection<Projet> getProjets() {
        return projets;
    }

    public void setProjets(Collection<Projet> projets) {
        this.projets = projets;
    }
}
