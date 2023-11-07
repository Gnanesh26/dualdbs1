package com.example.dualdatabase.builder;


import com.example.dualdatabase.entity1.Orders;
import com.example.dualdatabase.entity1.OrdersDTO;


public class ObjectBuilder {


    public static Orders createOrderFromordersDTO(OrdersDTO ordersDTO) {
        Orders orders = new Orders();
        orders.setName(ordersDTO.getName());
        orders.setCode(ordersDTO.getCode());
        orders.setInvoiceNumber(ordersDTO.getInvoiceNumber());
        orders.setTotalPrice(ordersDTO.getTotalPrice());
        orders.setId(orders.getId());
        return orders;
    }


    public static com.example.dualdatabase.entity2.Orders createOrderFromappordersDTO(com.example.dualdatabase.entity2.OrdersDTO ordersDTO) {
        com.example.dualdatabase.entity2.Orders orders = new com.example.dualdatabase.entity2.Orders();
        orders.setName(ordersDTO.getName());
        orders.setTotalPrice(ordersDTO.getTotalPrice());
        orders.setInvoiceNumber(ordersDTO.getInvoiceNumber());
        return orders;
    }


}

