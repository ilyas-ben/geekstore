package com.proj.controller;


import com.proj.model.Cart;
import com.proj.model.User;
import com.proj.service.CartService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{idUser}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable int idUser){
        System.out.println("hello");
        Cart userCart = cartService.getCartByUserId(idUser);
        return ResponseEntity.ok(userCart);
    }

    @GetMapping("/currentUser")
    public ResponseEntity<Cart> getCurrentUserCart(HttpSession session){
        System.out.println("hello"); // just to test
        User currentUser = (User) session.getAttribute("loggedInUser");
        Cart userCart = cartService.getCartByUserId(currentUser.getIdUtilisateur());
        return ResponseEntity.ok(userCart);
    }
    @DeleteMapping("/{idProduit}")
    public void deleteProduitFromCartByPid(@PathVariable int idProduit, HttpServletResponse response, HttpSession session){
        User user =(User) session.getAttribute("loggedInUser");
        cartService.deleteProduitFromCartByPid(user.getIdUtilisateur(), idProduit);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/{idProduit}")
    public void decrement(@PathVariable int idProduit, HttpServletResponse response, HttpSession session){
        User user =(User) session.getAttribute("loggedInUser");
        cartService.decrement(user.getIdUtilisateur(), idProduit);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @DeleteMapping
    public void emptyCart(HttpSession session, HttpServletResponse response){
        User user = (User) session.getAttribute("loggedInUser");
        int userId = user.getIdUtilisateur();
        cartService.emptyCartByUserId(userId);
        response.setStatus(HttpServletResponse.SC_OK);
    }


}
