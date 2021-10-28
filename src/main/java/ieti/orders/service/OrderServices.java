package ieti.orders.service;

import ieti.orders.dto.OrderDto;
import ieti.orders.repository.OrderDocument;
import ieti.orders.repository.OrderRepository;
import ieti.orders.repository.ProductRepository;
import org.springframework.stereotype.Service;
import error.exception.NotFoundException;
import error.exception.UnavailableProductsException;
import models.ProductDocument;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServices {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServices(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository=orderRepository;
        this.productRepository=productRepository;
    }

    public OrderDocument create(OrderDto orderDto){
        OrderDocument order = new OrderDocument(orderDto);
        if(existsProducts(order.getProducts())) return orderRepository.save(order);
        throw new UnavailableProductsException("Some products do not exist.");
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

    public boolean delete(String id) {
        OrderDocument order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("Sale not found");
    }

    private boolean existsProducts(HashMap<String,Integer> products) {
        for (String product: products.keySet()) {
            if(productRepository.findById(product).orElse(null)==null) {
                return false;
            }
        }
        return true;
    }

}
