package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.services.SubscriptionServiceImpl;

public class StartSubscriptionCommand implements CommandImpl {

    private final SubscriptionServiceImpl subscriptionService;

    public StartSubscriptionCommand(SubscriptionServiceImpl subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            String startDateStr = tokens.get(Constants.ONE);
            subscriptionService.startSubscriptionForUser(startDateStr);
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}