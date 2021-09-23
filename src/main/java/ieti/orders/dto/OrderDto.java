package ieti.orders.dto;

import java.util.List;

public class OrderDto {
    List<String> sales;

    Double totalPrice;

    public List<String> getSales() {
        return sales;
    }

    public void setSales(List<String> sales) {
        this.sales = sales;
    }

    public Double getTotalPrice() {
        Double price = 0.0;
        List<SalesDocument> salesDoc= (List<ProductDocument>) sales;
        for(SalesDocument sale : salesDoc){
            price+=sale.getAmount();
        }
        return price;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
