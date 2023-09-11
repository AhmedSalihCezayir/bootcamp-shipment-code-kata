package com.trendyol.shipment;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatingShipmentSizeCalculator implements ShipmentSizeCalculator {
    private final Integer PRODUCT_SIZE_REPEAT_THRESHOLD = 3;

    @Override
    public ShipmentSize calculate(List<Product> products) {
        Map<ShipmentSize, Long> frequencyMap =
                products.stream().collect(Collectors.groupingBy(Product::getSize, Collectors.counting()));

        Map.Entry<ShipmentSize, Long> shipmentSizeAboveThreshold =
                frequencyMap.entrySet().stream()
                        .filter(entry -> entry.getValue() >= PRODUCT_SIZE_REPEAT_THRESHOLD).findFirst().orElse(null);

        return shipmentSizeAboveThreshold != null ? shipmentSizeAboveThreshold.getKey().next() : getBiggestProductSize(products);
    }

    private ShipmentSize getBiggestProductSize(List<Product> products) {
        return Collections.max(products).getSize();
    }
}
