package com.proj.enumm;


public enum Category {
    NULL(0),
    LAPTOP(1),
    DESKTOPPC(2),
    ACCESSORIES(3);

    int categoryNumber;

    Category(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public static Category getCategoryByItsIndex(int number) {
        for (Category category : Category.values()) {
            if (category.categoryNumber == number) {
                return category;
            }
        }
        return null; // Retourne NULL si aucune correspondance trouvée
    }
}