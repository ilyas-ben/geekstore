package com.proj.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommande;

    @Column
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "commandes_produits",
            joinColumns = @JoinColumn(name = "cmd_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    @Column
    private List<Produit> produits;

    @ManyToOne
    private User client;

    @Column
    private String typePaiment;

    @Column
    private Boolean paye;


    public Commande() {
    }

    public Commande(Integer idCommande, Date date, List<Produit> produits, User user, String typePaiment, Boolean paye) {
        this.idCommande = idCommande;
        this.date = date;
        this.produits = produits;
        this.client = user;
        this.typePaiment = typePaiment;
        this.paye = paye;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getTypePaiment() {
        return typePaiment;
    }

    public void setTypePaiment(String typePaiment) {
        this.typePaiment = typePaiment;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", date=" + date +
                ", produits=" + produits +
                ", user=" + client +
                ", typePaiment='" + typePaiment + '\'' +
                ", paye=" + paye +
                '}';
    }
}
