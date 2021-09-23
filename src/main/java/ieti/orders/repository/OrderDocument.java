package ieti.orders.repository;

import ieti.orders.dto.OrderDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class OrderDocument {
    @Id
    String id;

    List<String> sales;

    Date orderDate;

    Double totalPrice;

    public OrderDocument(OrderDto orderDto){
        this.sales=orderDto.getSales();
        this.totalPrice=orderDto.getTotalPrice();
        this.orderDate=new Date();
    }

    public void update(OrderDto orderDto){
        this.sales=orderDto.getSales();
        this.totalPrice=orderDto.getTotalPrice();
    }

    public List<String> getSales() {
        return sales;
    }

    public void setSales(List<String> sales) {
        this.sales = sales;
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