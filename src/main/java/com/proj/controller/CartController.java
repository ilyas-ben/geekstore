package com.proj.controller;


import com.proj.model.Cart;
import com.proj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{idUser}")
    public Cart getCartByUserId(@PathVariable int idUser){
        return cartService.getCartByUserId(idUser);
    }


}
