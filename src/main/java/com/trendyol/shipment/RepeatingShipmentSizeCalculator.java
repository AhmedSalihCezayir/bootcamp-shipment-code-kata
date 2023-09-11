package com.trendyol.shipment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingShipmentSizeCalculator implements ShipmentSizeCalculator {
    private final Integer THRESHOLD = 3;

    @Override
    public ShipmentSize calculate(List<Product> products) {
        return getRepeatingProductSize(products);
    }

    private HashMap<ShipmentSize, Integer> getFrequencyMapOfProductsList(List<Product> products) {
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

    private ShipmentSize getBiggestProductSize(List<Product> products) {
        ShipmentSize max = ShipmentSize.SMALL;

        for (Product product: products) {
            if (max.compareTo(product.getSize()) < 0) {
                max = product.getSize();
            }
        }

        return max;
    }

    private ShipmentSize getRepeatingProductSize(List<Product> products) {
        HashMap<ShipmentSize, Integer> frequencyMap = getFrequencyMapOfProductsList(products);

        for (Map.Entry<ShipmentSize, Integer> sizeFrequency: frequencyMap.entrySet()) {
            if (sizeFrequency.getValue() >= THRESHOLD) {
                return sizeFrequency.getKey().getNextBiggerSize();
            }
        }
        return getBiggestProductSize(products);
    }
}
