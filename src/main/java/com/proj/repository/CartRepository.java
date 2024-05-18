package com.proj.repository;

import com.proj.model.Cart;
import com.proj.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query("SELECT c FROM Cart c WHERE c.client.id = :idUser  ")
    Cart getCartByUserId(@Param("idUser") Integer idUser);

    @Query("SELECT c.produits FROM Cart c WHERE c.id =:idCart ")
    List<Produit> getProductsOfCartByCartId(@Param("idCart") Integer idCart);


}
