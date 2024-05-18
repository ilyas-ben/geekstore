package com.proj.enumm;

public enum UserType {
    NULL(0),
    CLIENT(1),
    FOURNISSEUR(2), // furnisher
    ADMIN(3);

    int userTypeNumber;

    UserType(int userTypeNumber) {
        this.userTypeNumber = userTypeNumber;
    }
}
