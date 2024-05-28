package com.proj.service;


import com.proj.model.Cart;
import com.proj.model.Produit;
import com.proj.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CartService {

   @Autowired
   private CartRepository cartRepository;

   public void saveCart(Cart cartToAdd){
        cartRepository.save(cartToAdd);
   }

   public Cart getCartById(Integer idCart){
       return cartRepository.findById(idCart).get();
   }

   public Cart getCartByUserId(Integer idUser){
       return cartRepository.getCartByUserId(idUser);
   }

   public List<Produit> getProductsOfCartByCartId(Integer idCart){
       return cartRepository.getProductsOfCartByCartId(idCart);
   }

    public void deleteProduitFromCartByPid(int idUser, int idProduit) {
        Cart cart = getCartByUserId(idUser);
        List<Produit> produits = cart.getProduits();

        Iterator<Produit> iterator = produits.iterator();
        while (iterator.hasNext()) {
            Produit produit = iterator.next();
            if (produit != null && produit.getIdProduit() == idProduit) {
                iterator.remove();
                System.out.println("has been deleted inside java");
            }
        }

       System.out.println(produits);

       cart.setProduits(produits);
       saveCart(cart);
    }

    public void decrement(Integer idUser, int idProduit) {
        Cart cart = getCartByUserId(idUser);
        List<Produit> produits = cart.getProduits();

        for(Produit produit : produits){
            System.out.println(produit);
        }

        for(Produit produit : produits){
            if(produit.getIdProduit()==idProduit){
                produits.remove(produit);
                System.out.println("has been deleted inside java");
                break;
            }
        }


        cart.setProduits(produits);
        saveCart(cart);
    }

    public void emptyCartByUserId(int userId) {
       cartRepository.emptyCartByUserId(userId);
    }


    public void createCart(Integer idUtilisateur) {

    }
}
