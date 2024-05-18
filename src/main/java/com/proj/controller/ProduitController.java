package com.proj.controller;


import com.proj.enumm.Category;
import com.proj.model.Cart;
import com.proj.model.Produit;
import com.proj.model.User;
import com.proj.service.CartService;
import com.proj.service.ProduitService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private CartService cartService;

    @GetMapping("/displayProductsByCategory/{categoryIndex}")
    public String displayProductsByCategoryindex(@PathVariable Integer categoryIndex, Model model, HttpSession session){
        Category category = Category.getCategoryByItsIndex(categoryIndex);
        List<Produit> produits = produitService.getProductsByCategory(category);
        model.addAttribute("products", produits);
        User user = (User) session.getAttribute("loggedInUser");
        model.addAttribute("cart", cartService.getCartByUserId(user.getIdUtilisateur()));
        return "client/laptops";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id, Model model){
        Produit produit = produitService.getProductById(id);
        model.addAttribute(produit);
        return "client/detailProduit";
    }

    @PutMapping("addToCart/{idProduct}")
    public void addProductToCartByProductId(@PathVariable Integer idProduct, HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedInUser");
        Cart cart = cartService.getCartByUserId(user.getIdUtilisateur());
        Produit produit = produitService.getProductById(idProduct);

        List<Produit> cartProduits = cart.getProduits();
        cartProduits.add(produit);

        cart.setProduits(cartProduits);

        cartService.saveCard(cart);
    }
}
