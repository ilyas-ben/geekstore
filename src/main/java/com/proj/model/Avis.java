package com.proj.model;

import jakarta.persistence.*;

@Entity
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvis;

    @Column
    private String commentaire;

    @Column
    private Integer rate;

    @ManyToOne
    private User client;

    @ManyToOne
    private Produit produit; // the product which this comment or rate are about

    public Avis() {
    }

    public Avis(Integer idAvis, String commentaire, Integer rate, User client) {
        this.idAvis = idAvis;
        this.commentaire = commentaire;
        this.rate = rate;
        this.client = client;
    }

    public Avis(Integer idAvis, String commentaire, Integer rate, User client, Produit produit) {
        this.idAvis = idAvis;
        this.commentaire = commentaire;
        this.rate = rate;
        this.client = client;
        this.produit = produit;
    }



    public Integer getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "idAvis=" + idAvis +
                ", commentaire='" + commentaire + '\'' +
                ", rate=" + rate +
                ", client=" + client +
                ", produit=" + produit +
                '}';
    }
}
