package com.proj.repository;

import com.proj.enumm.Category;
import com.proj.model.Produit;
import com.proj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    @Query("SELECT p FROM Produit p WHERE p.category = :category")
    List<Produit> getProductsByCategory(@Param("category") Category category);
}
