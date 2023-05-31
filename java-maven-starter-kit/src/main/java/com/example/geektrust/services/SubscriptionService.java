package com.example.geektrust.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Device;
import com.example.geektrust.entities.DoReMiSubscription;
import com.example.geektrust.entities.Subscription;
import com.example.geektrust.entities.factory.DeviceFactory;
import com.example.geektrust.entities.factory.SubscriptionFactoryProducer;
import com.example.geektrust.enums.DeviceType;
import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionPlan;
import com.example.geektrust.enums.SubscriptionStatus;
import com.example.geektrust.enums.TopUpStatus;
import com.example.geektrust.exceptions.AddSubscriptionFailedException;
import com.example.geektrust.exceptions.AddTopUpFailedException;
import com.example.geektrust.exceptions.InvalidDateException;

public class SubscriptionService implements SubscriptionServiceImpl {
    private final DoReMiSubscription doReMiSubscription;
    private final DateTimeFormatter dateFormatter;

    public SubscriptionService(DoReMiSubscription doReMiSubscription) {
        this.doReMiSubscription = doReMiSubscription;
        this.dateFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
    }

    private boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public void startSubscriptionForUser(String dateStr) throws InvalidDateException {
        if (!isValidDate(dateStr)) {
            throw new InvalidDateException("INVALID_DATE");
        }
        LocalDate startingDate = LocalDate.parse(dateStr, dateFormatter);
        doReMiSubscription.addDateOfSubscription(startingDate);
    }

    @Override
    public void addSubscriptionForUser(SubscriptionCategory subscriptionCategory, SubscriptionPlan subscriptionPlan) throws AddSubscriptionFailedException {
        if (doReMiSubscription.getSubscriptionStatus().equals(SubscriptionStatus.NOT_STARTED)) {
            throw new AddSubscriptionFailedException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
        if (doReMiSubscription.isSubscriptionCategoryExistInCurrentPlan(subscriptionCategory)) {
            throw new AddSubscriptionFailedException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        }
        Subscription subscription = SubscriptionFactoryProducer.getSubscription(subscriptionCategory, subscriptionPlan);
        doReMiSubscription.addSubscriptionToCurrentPlan(subscriptionCategory, subscription);
    }

    @Override
    public void addTopUpForUser(DeviceType deviceType, Integer noOfMonths) throws AddTopUpFailedException {
        if (doReMiSubscription.getSubscriptionStatus().equals(SubscriptionStatus.NOT_STARTED)) {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED INVALID_DATE");
        }
        if (doReMiSubscription.getSubscriptionStatus().equals(SubscriptionStatus.STARTED)) {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
        }
        if (doReMiSubscription.getTopUpStatus().equals(TopUpStatus.ADDED)) {
            throw new AddTopUpFailedException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
        Device device = DeviceFactory.getDevice(deviceType);
        doReMiSubscription.addAdditionalDevices(device, noOfMonths);
    }
}