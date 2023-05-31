package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.dto.RenewalAmountDto;
import com.example.geektrust.dto.RenewalReminderDto;
import com.example.geektrust.exceptions.SubscriptionNotFoundException;

public interface RenewalServiceImpl {
    List<RenewalReminderDto> calculateListOfRenewalDateOfSubscriptions() throws SubscriptionNotFoundException;

    RenewalAmountDto calculateRenewalAmount();
}