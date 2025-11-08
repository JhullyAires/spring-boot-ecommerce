package com.olires.spring_boot_ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olires.spring_boot_ecommerce.dao.CustomerRepository;
import com.olires.spring_boot_ecommerce.dto.Purchase;
import com.olires.spring_boot_ecommerce.dto.PurchaseResponse;
import com.olires.spring_boot_ecommerce.entity.Customer;
import com.olires.spring_boot_ecommerce.entity.Order;
import com.olires.spring_boot_ecommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override // implementing the method from CheckoutService interface
    @Transactional // Ensures that the method runs within a database transaction
    public PurchaseResponse placeOrder(Purchase purchase) {
        
        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billing and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID (Universally Unique Identifier)
        return UUID.randomUUID().toString();
    }

}
