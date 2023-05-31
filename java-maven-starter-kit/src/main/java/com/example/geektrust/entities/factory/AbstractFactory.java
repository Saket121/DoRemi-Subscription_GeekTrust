package com.example.geektrust.entities.factory;

import com.example.geektrust.entities.Subscription;
import com.example.geektrust.enums.SubscriptionPlan;

public abstract class AbstractFactory {
    abstract Subscription getSubscriptionPlan(SubscriptionPlan subscriptionPlanType);
}

