package com.proj.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReclamation;

    @Column
    private String description;

    @Column
    private Date dateReclamation;

    @OneToMany
    private List<Commande> commandes;

    @ManyToOne
    private User client;

    public Reclamation() {
    }

    public Reclamation(Integer idReclamation, String description, Date dateReclamation, List<Commande> commandes) {
        this.idReclamation = idReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.commandes = commandes;
    }

    public Reclamation(Integer idReclamation, String description, Date dateReclamation, List<Commande> commandes, User client) {
        this.idReclamation = idReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.commandes = commandes;
        this.client = client;
    }

    public Integer getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "idReclamation=" + idReclamation +
                ", description='" + description + '\'' +
                ", dateReclamation=" + dateReclamation +
                ", commandes=" + commandes +
                ", client=" + client +
                '}';
    }

}
