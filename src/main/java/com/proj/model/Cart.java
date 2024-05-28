package com.proj.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCart;

    @OneToOne
    private User client;

    @ManyToMany
    @JoinTable(
            name = "cartProducts",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Produit> produits;

    // Constructeurs, getters et setters
    public Cart() {
    }

    public Cart(User client, List<Produit> produits) {
        this.client = client;
        this.produits = produits;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
