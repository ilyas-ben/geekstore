package com.proj.service;

import com.proj.enumm.DeliveryStatus;
import com.proj.enumm.PaymentMethod;
import com.proj.exceptions.PaymentException;
import com.proj.model.Cart;
import com.proj.model.Commande;
import com.proj.model.Produit;
import com.proj.model.User;
import com.proj.repository.CommandeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CartService cartService;

    public int save(Commande commande, String[] infoCardInArray, int paymentmethodindex, HttpSession session) throws Exception {
            User client = (User) session.getAttribute("loggedInUser");
            String infoCard="null";


            Cart cart = cartService.getCartByUserId(client.getIdUtilisateur());
            PaymentMethod method = PaymentMethod.getPaymentMethodByItsIndex(paymentmethodindex);

            commande.setTypePaiment(method);
            System.out.println(""+method);
            commande.setClient(client);
            commande.setDate(LocalDateTime.now());
            commande.setDeliveryStatus(DeliveryStatus.EN_ATTENTE_DE_COLLECTE);
            // total price is setted automaticly in thymleaf template
            if(method == PaymentMethod.CARTE_BANCAIRE){
                confirmPayment();
                infoCard = String.join("\n", infoCardInArray);
                commande.setPaye(true);
            }else commande.setPaye(false);
            commande.setInfoPaiement(infoCard);
            List<Produit> produits = cart.getProduits();
            cart.setProduits(null);
            commande.setProduits(produits);
            return commandeRepository.save(commande).getIdCommande();

    }

    private void confirmPayment() throws PaymentException {
        boolean a;
        System.out.println("1: Confirmer paiment\n2:Carte incorrecte\n3:Probleme avec serveur de paiment\4:Probleme avec votre carte");
        System.out.println("Choix : ");
        int choix = new Scanner(System.in).nextInt();
        if (!(choix == 1)) {
        String message ;

            message = null;

            switch (choix) {
                case 1:
                    message = "Confirmer paiement";
                    break;
                case 2:
                    message = "Carte incorrecte";
                    break;
                case 3:
                    message = "Problème avec serveur de paiement";
                    break;
                case 4:
                    message = "Problème avec votre carte";
                    break;
                default:
                    message = "Choix invalide";
                    break;
            }

        throw new PaymentException(message);

        }
    }


    public Commande getCommandById(int id) {
        return commandeRepository.findById(id).get();
    }

    public List<Produit> getCommandeProduitsByCId(int id) {
        return commandeRepository.findById(id).get().getProduits();
    }

    public List<Commande> getCommmandesByUserId(Integer idUtilisateur) {
        return  commandeRepository.getCommmandesByUserId(idUtilisateur);
    }
}


