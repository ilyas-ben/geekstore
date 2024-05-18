package com.proj.model;

import com.proj.enumm.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;

    @Column
    private String nomP;

    @Column
    private String description;

    @Column
    private Integer prix;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Column
    private Integer quantityStock;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private User fournisseur; // who is sellling that product

    @OneToMany
    private List<Avis> avis;

    public Produit() {
    }

    public Produit(Integer idProduit, String nomP, String description, Integer prix, Category category, Integer quantityStock, User fournisseur, List<Avis> avis) {
        this.idProduit = idProduit;
        this.nomP = nomP;
        this.description = description;
        this.prix = prix;
        this.category = category;
        this.quantityStock = quantityStock;
        this.fournisseur = fournisseur;
        this.avis = avis;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public User getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(User fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nomP='" + nomP + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", category=" + category +
                ", quantityStock=" + quantityStock +
                ", fournisseur=" + fournisseur +
                ", avis=" + avis +
                '}';
    }
}
