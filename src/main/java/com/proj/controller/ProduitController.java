package com.proj.controller;


import com.proj.enumm.Category;
import com.proj.model.Cart;
import com.proj.model.Produit;
import com.proj.model.User;
import com.proj.service.CartService;
import com.proj.service.ProduitService;
import com.proj.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 /***************            ecom.sql kayn fmes documents                 **************/
@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/displayProductsByCategory/{categoryIndex}")
    public String displayProductsByCategoryindex(@PathVariable Integer categoryIndex, Model model, HttpSession session){
        Category category = Category.getCategoryByItsIndex(categoryIndex);
        List<Produit> produits = produitService.getProductsByCategory(category);
        model.addAttribute("products", produits);
        User user = (User) session.getAttribute("loggedInUser");

        if(categoryIndex==1){
            return "client/laptops";
        } else if (categoryIndex == 2){
            return "client/desks";
        } else if (categoryIndex == 3) {
            return "client/accesoires";
        }
        else{
            return "error";
        }

    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id, Model model){
        Produit produit = produitService.getProductById(id);
        model.addAttribute(produit);
        return "client/detailProduit";
    }

    @GetMapping("json/{id}")
    public ResponseEntity<Produit> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(produitService.getProductById(id));
    }

    @PutMapping("addToCart/{idProduct}")
    public void addProductToCartByProductId(@PathVariable Integer idProduct, Model model, HttpSession session, HttpServletResponse response ) throws IOException {
        User user = (User) session.getAttribute("loggedInUser");
        Cart cart = cartService.getCartByUserId(user.getIdUtilisateur());
        Produit produit = produitService.getProductById(idProduct);

        List<Produit> cartProduits = null;
        try {
            cartProduits = cart.getProduits();
        } catch (NullPointerException e) {
            Cart cart1 = new Cart(userService.getUserById(user.getIdUtilisateur()),null);
            cartService.saveCart(cart1);
            cart = cartService.getCartByUserId(user.getIdUtilisateur());
            cartProduits = new ArrayList<Produit>();
        }
        cartProduits.add(produit);

        cart.setProduits(cartProduits);

        cartService.saveCart(cart);

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
