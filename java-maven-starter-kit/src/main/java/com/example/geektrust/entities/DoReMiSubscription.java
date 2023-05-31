package com.example.geektrust.entities;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionStatus;
import com.example.geektrust.enums.TopUpStatus;

public class DoReMiSubscription {
    private LocalDate startDateOfSubscription;
    private final Map<SubscriptionCategory, Subscription> listOfSubscription;
    private SubscriptionStatus subscriptionStatus;
    private TopUpStatus topUpStatus;
    private Integer noOfMonthsForTopUp;
    private Device device;

    public DoReMiSubscription() {
        this.startDateOfSubscription = null;
        this.listOfSubscription = new TreeMap<>();
        this.subscriptionStatus = SubscriptionStatus.NOT_STARTED;
        this.topUpStatus = TopUpStatus.EMPTY;
        this.noOfMonthsForTopUp = 0;
        this.device = null;
    }

    public void addDateOfSubscription(LocalDate dateOfSubscription) {
        this.startDateOfSubscription = dateOfSubscription;
        this.subscriptionStatus = SubscriptionStatus.STARTED;
    }

    public void addSubscriptionToCurrentPlan(SubscriptionCategory subscriptionCategoryType, Subscription subscription) {
        this.subscriptionStatus = SubscriptionStatus.ADDED;
        listOfSubscription.put(subscriptionCategoryType, subscription);
    }

    public boolean isSubscriptionCategoryExistInCurrentPlan(SubscriptionCategory subscriptionCategory) {
        return listOfSubscription.containsKey(subscriptionCategory);
    }

    public void addAdditionalDevices(Device device, Integer noOfMonths) {
        this.topUpStatus = TopUpStatus.ADDED;
        this.noOfMonthsForTopUp = noOfMonths;
        this.device = device;
    }

    public LocalDate getStartDateOfSubscription() {
        return startDateOfSubscription;
    }

    public Map<SubscriptionCategory, Subscription> getListOfSubscription() {
        return new TreeMap<>(listOfSubscription);
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public TopUpStatus getTopUpStatus() {
        return topUpStatus;
    }

    public Integer getNoOfMonthsForTopUp() {
        return noOfMonthsForTopUp;
    }

    public Device getDevice() {
        return device;
    }
}