package ieti.orders.service;

import ieti.orders.dto.OrderDto;
import ieti.orders.repository.OrderDocument;
import ieti.orders.repository.OrderRepository;
import ieti.orders.repository.SaleRepository;
import org.springframework.stereotype.Service;
import models.SaleDocument;
import error.exception.NotFoundException;

import java.util.List;

@Service
public class OrderServices {

    private final OrderRepository orderRepository;
    private final SaleRepository saleRepository;

    public OrderServices(OrderRepository orderRepository, SaleRepository saleRepository) {
        this.orderRepository=orderRepository;
        this.saleRepository=saleRepository;
    }

    public OrderDocument create(OrderDto orderDto){
        OrderDocument order = new OrderDocument(orderDto);
        return orderRepository.save(order);
    }

    public OrderDocument updateOrder(String id, OrderDto orderDto){
        OrderDocument order = orderRepository.findById(id).orElse(null);
        if(order != null){
            order.update(orderDto);
            return orderRepository.save(order);
        }
        throw new NotFoundException("Order not found.");
    }

    public List<OrderDocument> getAll(){
        return orderRepository.findAll();
    }

    public OrderDocument findById(String id){
        OrderDocument order = orderRepository.findById(id).orElse(null);
        if(order != null) return order;
        throw new NotFoundException("Order not found.");
    }


}
