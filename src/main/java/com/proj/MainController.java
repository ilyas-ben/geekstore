package com.proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/SignUp.html")
    public String showSignUpPage(){
        return "SignUp";
    }

    @GetMapping("/LogIn.html")
    public String showLogInPage(){
        return "LogIn";
    }

    @GetMapping("/Session.html")
    public String sessionOpening(){
        return "Session";
    }

    @GetMapping("/Session1.html")
    public String sessionOpening1(){
        return "Session1";
    }

    @GetMapping("/Session2.html")
    public String sessionOpening2(){
        return "Session2";
    }

    @GetMapping("/MonCompte.html")
    public String showUsForm(){
        return "MonCompte";
    }

    @GetMapping("/EditUser.html")
    public String showUpdateUserForm(){
        return "EditUser";
    }

}
