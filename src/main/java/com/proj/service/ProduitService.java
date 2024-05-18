package com.proj.service;

import com.proj.enumm.Category;
import com.proj.model.Produit;
import com.proj.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getProductsByCategory(Category category) {
        return produitRepository.getProductsByCategory(category);
    }

    public Produit getProductById(Integer id) {
        return produitRepository.findById(id).get();
    }
}
