package com.trendyol.shipment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private List<Product> products;
    private final Integer THRESHOLD = 3;

    public ShipmentSize getShipmentSize() {
            return getRepeatingProductSize();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private HashMap<ShipmentSize, Integer> getFrequencyMapOfProductsList() {
        HashMap<ShipmentSize, Integer> frequencyMap = new HashMap<>();

        for (Product product: products) {
            ShipmentSize productSize = product.getSize();
            if (frequencyMap.containsKey(productSize)) {
                frequencyMap.put(productSize, frequencyMap.get(productSize) + 1);
            } else {
                frequencyMap.put(productSize, 1);
            }
        }

        return frequencyMap;
    }

    private ShipmentSize getBiggestProductSize() {
        ShipmentSize max = ShipmentSize.SMALL;

        for (Product product: products) {
            if (max.compareTo(product.getSize()) < 0) {
                max = product.getSize();
            }
        }

        return max;
    }
    
    private ShipmentSize getRepeatingProductSize() {
        HashMap<ShipmentSize, Integer> frequencyMap = getFrequencyMapOfProductsList();

        for (Map.Entry<ShipmentSize, Integer> sizeFrequency: frequencyMap.entrySet()) {
            if (sizeFrequency.getValue() >= THRESHOLD) {
                return sizeFrequency.getKey().getNextBiggerSize();
            }
        }
        return getBiggestProductSize();
    }
}
