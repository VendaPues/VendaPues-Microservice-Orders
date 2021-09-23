package ieti.orders.controller;

import ieti.orders.dto.OrderDto;
import ieti.orders.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderServices orderServices;

    public OrderController(@Autowired OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(orderServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return ResponseEntity.ok(orderServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderServices.create(orderDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody OrderDto orderDto){
        if(orderDto==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(orderServices.updateOrder(id, orderDto));
    }
}