package com.trendyol.shipment;

import java.util.List;

public interface ShipmentSizeCalculator {
    ShipmentSize calculate(List<Product> products);
}
