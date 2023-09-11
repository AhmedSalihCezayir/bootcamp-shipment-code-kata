package com.trendyol.shipment;

import java.util.List;

public class Basket {

    private List<Product> products;
    private final ShipmentSizeCalculator shipmentSizeCalculator = new RepeatingShipmentSizeCalculator();

    public ShipmentSize getShipmentSize() {
        return shipmentSizeCalculator.calculate(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
