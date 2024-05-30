package com.proj.controller;


import com.proj.exceptions.PaymentException;
import com.proj.model.Cart;
import com.proj.model.Commande;
import com.proj.model.Produit;
import com.proj.model.User;
import com.proj.service.CartService;
import com.proj.service.CommandeService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CartService cartService;

    @GetMapping("/form")
    public String commandForm(Model model, HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        Cart cart = cartService.getCartByUserId(user.getIdUtilisateur());
        List<Produit> produits = cart.getProduits();

        Commande commande = new Commande();
        commande.setProduits(cart.getProduits());
        model.addAttribute(commande);

        return "client/commandForm";
    }

    @PostMapping
    private ResponseEntity<String> saveCommand(Model model,
                                               @RequestParam int paymentmethod,
                                               @RequestParam String[] infocard,
                                               @ModelAttribute Commande commande,
                                               HttpSession session,
                                               HttpServletResponse response
                                               ) throws Exception {
        try {
            int id = commandeService.save(commande, infocard, paymentmethod,session);
            System.out.println("id command"+id);
            response.sendRedirect("http://localhost:8080/commande/"+id);
            return ResponseEntity.ok().build();
        } catch (PaymentException e) {
            return ResponseEntity.internalServerError().body(e.getMessage()+" Cliquez sur précédent");
        }
    }

    @GetMapping("/{id}")
    private String getCommandById(@PathVariable int id, Model model){
        model.addAttribute("commande", commandeService.getCommandById(id));
        return "client/detailCommande";
    }


    @GetMapping("/{id}/produits")
    private ResponseEntity<List<Produit>> getCommandeProduitsByCID(@PathVariable int id){
        return ResponseEntity.ok(commandeService.getCommandeProduitsByCId(id));
    }

    @GetMapping("/user/")
    private ResponseEntity<List<Commande>> getCommmandesByUserId(HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        return ResponseEntity.ok(commandeService.getCommmandesByUserId(user.getIdUtilisateur()));
    }

}
