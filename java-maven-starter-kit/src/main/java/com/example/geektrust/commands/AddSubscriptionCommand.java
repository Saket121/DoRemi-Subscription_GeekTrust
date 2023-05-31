package com.example.geektrust.commands;



import java.util.List;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionPlan;
import com.example.geektrust.exceptions.AddSubscriptionFailedException;
import com.example.geektrust.services.SubscriptionServiceImpl;

public class AddSubscriptionCommand implements CommandImpl {
    private final SubscriptionServiceImpl subscriptionService;

    public AddSubscriptionCommand(SubscriptionServiceImpl subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            SubscriptionCategory subscriptionCategory = SubscriptionCategory.valueOf(tokens.get(Constants.ONE));
            SubscriptionPlan subscriptionPlan = SubscriptionPlan.valueOf(tokens.get(Constants.TWO));
            subscriptionService.addSubscriptionForUser(subscriptionCategory, subscriptionPlan);
        } catch (AddSubscriptionFailedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}