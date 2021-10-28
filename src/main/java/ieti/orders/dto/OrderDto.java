package ieti.orders.dto;

import ieti.orders.repository.OrderDocument;

import java.util.HashMap;
import java.util.List;

public class OrderDto {

    HashMap<String,Integer> products;

    Double totalPrice;

    public HashMap<String,Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
