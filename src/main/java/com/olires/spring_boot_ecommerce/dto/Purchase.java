package com.olires.spring_boot_ecommerce.dto;

import com.olires.spring_boot_ecommerce.entity.Customer;

import java.util.Set;

import com.olires.spring_boot_ecommerce.entity.Address;
import com.olires.spring_boot_ecommerce.entity.Order;
import com.olires.spring_boot_ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
