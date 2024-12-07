package com.tcshop.tcshopspring.stripe;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeClient {


    public StripeClient() {
        Stripe.apiKey = "sk_test_51QSkaPBRsOOftJf25aUhH6ftBXPJITFwSl0gIru33uw7N99I0ca9cqXsbHsApjVZ87if1vlLYwns4OdkspHOndcj00QLxxxHAM";
    }

    public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int) (amount * 100));
        chargeParams.put("currency", "PEN");
        chargeParams.put("source", token);
        return Charge.create(chargeParams);
    }
}
