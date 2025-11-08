package com.olires.spring_boot_ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber; // Another option is to use @NonNull annotation instead of final 
}
