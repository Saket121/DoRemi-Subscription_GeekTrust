package com.example.geektrust.services;

import com.example.geektrust.enums.DeviceType;
import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionPlan;
import com.example.geektrust.exceptions.AddSubscriptionFailedException;
import com.example.geektrust.exceptions.AddTopUpFailedException;
import com.example.geektrust.exceptions.InvalidDateException;

public interface SubscriptionServiceImpl {
    void startSubscriptionForUser(String dateStr) throws InvalidDateException;
    
    void addSubscriptionForUser(SubscriptionCategory subscriptionCategory, SubscriptionPlan subscriptionPlan) throws AddSubscriptionFailedException;
    
    void addTopUpForUser(DeviceType deviceType, Integer noOfDays) throws AddTopUpFailedException;
}