package com.trendyol.shipment;

public class Product implements Comparable<Product> {

    private ShipmentSize size;

    public static Product create(ShipmentSize shipmentSize) {
        Product productVO = new Product();
        productVO.setSize(shipmentSize);
        return productVO;
    }

    public ShipmentSize getSize() {
        return size;
    }

    public void setSize(ShipmentSize size) {
        this.size = size;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return size.compareTo(otherProduct.getSize());
    }
}
