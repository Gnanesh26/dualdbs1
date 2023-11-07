package com.example.dualdatabase.Controller;

import com.example.dualdatabase.builder.ObjectBuilder;
import com.example.dualdatabase.entity1.Orders;
import com.example.dualdatabase.entity1.OrdersDTO;

import com.example.dualdatabase.repo1.OrderRepository;
import com.example.dualdatabase.repo2.ApplicationOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ApplicationOrderRepository applicationOrderRepository;

    @PostMapping("/orders/mcloud")
    public Orders saveOrders(@RequestBody OrdersDTO ordersDTO) {
        Orders orders = ObjectBuilder.createOrderFromordersDTO(ordersDTO);
        return orderRepository.save(orders);
    }


//    @GetMapping("/order/{id}")
//    public String getOrder(@RequestParam("id") int id) {
//        // check if we have order with the id
//        // if we don't have, pull the order from mcloud
//        // save the order to our application db
//        // return the order
//        return "order";
//    }


    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") int id) {
        Optional<Orders> mcloudOrder = orderRepository.findById(id);

        if (mcloudOrder.isPresent()) {
            Orders existingOrder = mcloudOrder.get();

            com.example.dualdatabase.entity2.Orders applicationOrder = convertToApplicationOrder(existingOrder);
            applicationOrderRepository.save(applicationOrder);

            return ResponseEntity.ok(applicationOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private com.example.dualdatabase.entity2.Orders convertToApplicationOrder(Orders mcloudOrder) {
        com.example.dualdatabase.entity2.Orders applicationOrder = new com.example.dualdatabase.entity2.Orders();
        applicationOrder.setInvoiceNumber(mcloudOrder.getInvoiceNumber());
        applicationOrder.setTotalPrice(mcloudOrder.getTotalPrice());
        applicationOrder.setName(mcloudOrder.getName());
        return applicationOrder;
    }


    @PostMapping("/orders/application")
    public com.example.dualdatabase.entity2.Orders saveOrders(@RequestBody com.example.dualdatabase.entity2.OrdersDTO ordersDTO) {
        com.example.dualdatabase.entity2.Orders orders = ObjectBuilder.createOrderFromappordersDTO(ordersDTO);
        return applicationOrderRepository.save(orders);
    }

    @GetMapping("/allOrders/mcloud")
    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    }

    @GetMapping("/allOrders/application")
    public List<com.example.dualdatabase.entity2.Orders> getAllOrders() {
        return applicationOrderRepository.findAll();
    }
}
