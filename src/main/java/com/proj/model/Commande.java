package com.proj.model;


import com.proj.enumm.City;
import com.proj.enumm.DeliveryStatus;
import com.proj.enumm.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommande;

    @Column
    private LocalDateTime date;

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
    private Float totalPrice;

    @Column
    private String addressLine;

    @Enumerated(EnumType.ORDINAL)
    private City city;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod typePaiment; // 1 : à la livraison, 2: par carte

    @Column
    private String infoPaiement;

    @Column
    private Boolean paye;

    @Column
    private DeliveryStatus deliveryStatus;



    public Commande() {
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", date=" + date +
                ", produits=" + produits +
                ", client=" + client +
                ", totalPrice=" + totalPrice +
                ", addressLine='" + addressLine + '\'' +
                ", city=" + city +
                ", typePaiment=" + typePaiment +
                ", infoPaiement='" + infoPaiement + '\'' +
                ", paye=" + paye +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public PaymentMethod getTypePaiment() {
        return typePaiment;
    }

    public void setTypePaiment(PaymentMethod typePaiment) {
        this.typePaiment = typePaiment;
    }

    public String getInfoPaiement() {
        return infoPaiement;
    }

    public void setInfoPaiement(String infoPaiement) {
        this.infoPaiement = infoPaiement;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Commande(Integer idCommande, LocalDateTime date, List<Produit> produits, User client, Float totalPrice, String addressLine, City city, PaymentMethod typePaiment, String infoPaiement, Boolean paye, DeliveryStatus deliveryStatus) {
        this.idCommande = idCommande;
        this.date = date;
        this.produits = produits;
        this.client = client;
        this.totalPrice = totalPrice;
        this.addressLine = addressLine;
        this.city = city;
        this.typePaiment = typePaiment;
        this.infoPaiement = infoPaiement;
        this.paye = paye;
        this.deliveryStatus = deliveryStatus;
    }
}
