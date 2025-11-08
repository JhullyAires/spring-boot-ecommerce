package com.olires.spring_boot_ecommerce.service;

import com.olires.spring_boot_ecommerce.dto.Purchase;
import com.olires.spring_boot_ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
