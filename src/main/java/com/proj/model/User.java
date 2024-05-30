package com.proj.model;

import com.proj.enumm.UserType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String email;

    @Column
    private String mdP;

    @Column
    private String streetAdress;

    @Column
    private int phone;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    public User(Integer idUtilisateur, String nom, String prenom, String email, String mdP, UserType userType) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdP = mdP;
        this.userType = userType;
    }

    public User() {
        super();
    }



    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdP() {
        return this.mdP;
    }

    public void setMdP(String mdP) {
        this.mdP = mdP;
    }

    public UserType getUserType() {
        return userType;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }


    @Override
    public String toString() {
        return "User{" +
                "idUtilisateur=" + idUtilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdP='" + mdP + '\'' +
                ", streetAdress='" + streetAdress + '\'' +
                ", phone=" + phone +
                ", userType=" + userType +
                '}';
    }
}
