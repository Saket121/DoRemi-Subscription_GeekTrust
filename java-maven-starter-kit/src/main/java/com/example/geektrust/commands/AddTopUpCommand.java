package com.example.geektrust.commands;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.enums.DeviceType;
import com.example.geektrust.exceptions.AddTopUpFailedException;
import com.example.geektrust.services.SubscriptionServiceImpl;

import java.util.List;

public class AddTopUpCommand implements CommandImpl {

    private final SubscriptionServiceImpl subscriptionService;

    public AddTopUpCommand(SubscriptionServiceImpl subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            // Parse the device type from tokens
            DeviceType deviceType = DeviceType.valueOf(tokens.get(Constants.ONE));

            // Parse the number of months from tokens
            int noOfMonths = Integer.parseInt(tokens.get(Constants.TWO));

            // Add top-up for the user
            subscriptionService.addTopUpForUser(deviceType, noOfMonths);
        } catch (AddTopUpFailedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}