package com.proj.enumm;

public enum DeliveryStatus {
    EN_ATTENTE_DE_COLLECTE(0),
    LIVRAISON_EN_ROUTE(1),
    LIVREE(2);

    private final int index;

    DeliveryStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static DeliveryStatus getStatusWithIndex(int index) {
        for (DeliveryStatus status : DeliveryStatus.values()) {
            if (status.getIndex() == index) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid index: " + index);
    }
}
