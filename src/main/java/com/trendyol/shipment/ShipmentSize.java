package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    private static final ShipmentSize[] enumValues = values().clone();

    public ShipmentSize next() {
        boolean isBiggest = this.ordinal() == enumValues.length - 1;
        // For biggest enum, just return itself
        int nextEnumIndex = isBiggest ? this.ordinal() : this.ordinal() + 1;

        return enumValues[nextEnumIndex];
    }
}
