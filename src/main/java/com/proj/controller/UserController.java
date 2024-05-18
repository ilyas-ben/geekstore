package com.proj.controller;

import com.proj.enumm.Category;
import com.proj.model.Produit;
import com.proj.model.User;
import com.proj.enumm.UserType;
import com.proj.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //private Files session;
    private HttpSession session1;

    @GetMapping("/te")
    public String te(){
        return "te";
    }

    @GetMapping("/tes")
    public void tes(@ModelAttribute Category category){
        System.out.println(category);
    }

    @GetMapping("/logout")
    public String logOut(Model model, HttpSession session1){
        session1.invalidate();
        return "LogIn";
    }

    @GetMapping("/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        return "SignUp";
    }

    @PostMapping("/save")
    public String saveUser(User user){
        service.save(user);
        return "index";
    }



    @GetMapping("/cnx")
    public String showNewForm2(Model model){
        model.addAttribute("user",new User());
        return "LogIn";
    }

    @PostMapping ("/cnx2")
    public String Log(User user, Model model, HttpSession session1) {
        User retuser = null;
        retuser = service.getUserByEmail(user.getEmail());

        if (retuser != null && retuser.getMdP().equals(user.getMdP())) {
            // Vous pouvez ajouter des informations d'utilisateur à la session si nécessaire
            // ou utiliser Spring Security pour gérer l'authentification de manière plus robuste.

            // model.addAttribute("loggedInUser", retuser.getIdUtilisateur());
            System.out.println(retuser.toString());
            session1.setAttribute("loggedInUser", retuser);

            //33addToSession(retuser, model);

            if (retuser.getUserType() == UserType.CLIENT) {
                return "client/indd";
            } else if (retuser.getUserType() == UserType.ADMIN) {
                return "Session1";
            } else if (retuser.getUserType() == UserType.FOURNISSEUR) {
                return "Session2";
            } else {
                // Gérer d'autres types de comptes si nécessaire
                // Par exemple, vous pouvez renvoyer vers une page d'erreur.
                model.addAttribute("error", "Type de compte non pris en charge");

                return "LogIn";
            }
        } else {
            model.addAttribute("error", "Email ou mot de passe incorrect");
            System.out.println(retuser.toString());
            return "LogIn";
        }
    }

    @GetMapping("/tab")
    public String showUserDet(Model model){
        User user = (User) model.getAttribute("loggedInUser");
        model.addAttribute("user",new User());
        return "MonCompte";
    }


    @PostMapping("/tabu")
    public String GestUse(Model model, HttpSession session1) {
        //User user = (User) model.getAttribute("loggedInUser");
        User user = (User) session1.getAttribute("loggedInUser");
        model.addAttribute("user", user);
        return "MonCompte";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, HttpSession session1) {

        User loggedInUser = (User) session1.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);


        }
        return "EditUser";
    }

    @PostMapping("/save2")
    public String saveUser2(@ModelAttribute("user") User updatedUser, HttpSession session1){

        User existingUser = (User) session1.getAttribute("loggedInUser");

        existingUser.setPrenom(updatedUser.getPrenom());
        existingUser.setNom(updatedUser.getNom());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setMdP(updatedUser.getMdP());

        //session1.setAttribute("user", user);
        service.save(existingUser);
        return "MonCompte";
    }


}
