package com.proj.service;


import com.proj.model.Cart;
import com.proj.model.Produit;
import com.proj.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

   @Autowired
   private CartRepository cartRepository;

   public void saveCard(Cart cartToAdd){
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

}
