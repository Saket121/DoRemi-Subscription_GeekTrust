package com.example.geektrust.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.dto.RenewalAmountDto;
import com.example.geektrust.dto.RenewalReminderDto;
import com.example.geektrust.entities.Device;
import com.example.geektrust.entities.DoReMiSubscription;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionStatus;
import com.example.geektrust.enums.TopUpStatus;
import com.example.geektrust.exceptions.SubscriptionNotFoundException;

public class RenewalService implements RenewalServiceImpl {
    private final DoReMiSubscription doReMiSubscription;

    public RenewalService(DoReMiSubscription doReMiSubscription) {
        this.doReMiSubscription = doReMiSubscription;
    }

    @Override
    public List<RenewalReminderDto> calculateListOfRenewalDateOfSubscriptions() throws SubscriptionNotFoundException {
        if (doReMiSubscription.getSubscriptionStatus().equals(SubscriptionStatus.NOT_STARTED) || doReMiSubscription.getSubscriptionStatus().equals(SubscriptionStatus.STARTED)) {
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }

        List<RenewalReminderDto> renewalReminderDtoList = new ArrayList<>();
        Map<SubscriptionCategory, Subscription> subscriptionMap = doReMiSubscription.getListOfSubscription();

        for (Map.Entry<SubscriptionCategory, Subscription> entry : subscriptionMap.entrySet()) {
            SubscriptionCategory subscriptionCategory = entry.getKey();
            Subscription subscription = entry.getValue();
            LocalDate renewalDate = doReMiSubscription.getStartDateOfSubscription().plusMonths(subscription.getValidityInMonths()).minusDays(Constants.NO_OF_DAYS_BEFORE_TO_NOTIFIED);
            renewalReminderDtoList.add(new RenewalReminderDto(renewalDate, subscriptionCategory));
        }

        return renewalReminderDtoList;
    }

    @Override
    public RenewalAmountDto calculateRenewalAmount() {
        double amount = 0.0;
        Map<SubscriptionCategory, Subscription> subscriptionMap = doReMiSubscription.getListOfSubscription();

        for (Subscription subscription : subscriptionMap.values()) {
            amount += subscription.getPrice();
        }

        Device extraDevices = doReMiSubscription.getDevice();
        if (doReMiSubscription.getTopUpStatus().equals(TopUpStatus.ADDED) && extraDevices != null) {
            amount += extraDevices.getPrice() * doReMiSubscription.getNoOfMonthsForTopUp();
        }

        return new RenewalAmountDto((int) amount);
    }
}