package com.tcshop.tcshopspring.controllers;

import com.tcshop.tcshopspring.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final StripeClient stripeClient;

    @Autowired
    public PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Map<String, Object> charge(@RequestBody Map<String, Object> payload) {
        try {
            String token = (String) payload.get("stripeToken");
            double amount = (Double) payload.get("amount");
            return Map.of("charge", stripeClient.chargeNewCard(token, amount));
        } catch (Exception e) {
            return Map.of("error", e.getMessage());
        }
    }
}

