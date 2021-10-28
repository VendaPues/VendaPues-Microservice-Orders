package ieti.orders.repository;

import ieti.orders.dto.OrderDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document(collection = "orders")
public class OrderDocument {
    @Id
    String id;

    HashMap<String,Integer> products;

    Date orderDate;

    Double totalPrice;

    public OrderDocument(OrderDto orderDto){
        this.products=orderDto.getProducts();
        this.totalPrice=orderDto.getTotalPrice();
        this.orderDate=new Date();
    }

    public void update(OrderDto orderDto){
        this.products=orderDto.getProducts();
        this.totalPrice=orderDto.getTotalPrice();
    }

    public HashMap<String,Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String,Integer> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}