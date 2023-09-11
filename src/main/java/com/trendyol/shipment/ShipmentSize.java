package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    public ShipmentSize getNextBiggerSize() {
        switch (this) {
            case SMALL:
                return MEDIUM;
            case MEDIUM:
                return LARGE;
            case LARGE:
            case X_LARGE:
                return X_LARGE;
            default:
                throw new IllegalArgumentException("Invalid ShipmentSize: " + this);
        }
    }
}
