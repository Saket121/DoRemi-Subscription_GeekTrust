package com.example.geektrust.entities.factory;

import com.example.geektrust.entities.Subscription;
import com.example.geektrust.enums.SubscriptionCategory;
import com.example.geektrust.enums.SubscriptionPlan;
import com.example.geektrust.exceptions.SubscriptionInvalidTypeException;

public class SubscriptionFactoryProducer {
    private static AbstractFactory getSubscriptionCategoryFactory(SubscriptionCategory subscriptionCategoryType) {
        switch (subscriptionCategoryType) {
            case MUSIC:
                return new MusicSubscriptionFactory();
            case VIDEO:
                return new VideoSubscriptionFactory();
            case PODCAST:
                return new PodCastSubscriptionFactory();
            default:
                return null;
        }
    }

    public static Subscription getSubscription(SubscriptionCategory subscriptionCategoryType, SubscriptionPlan subscriptionPlanType) {
        AbstractFactory abstractFactory = SubscriptionFactoryProducer.getSubscriptionCategoryFactory(subscriptionCategoryType);
        if (abstractFactory == null) {
            throw new SubscriptionInvalidTypeException("SubscriptionCategory is Invalid!");
        }
        Subscription subscription = abstractFactory.getSubscriptionPlan(subscriptionPlanType);
        if (subscription == null) {
            throw new SubscriptionInvalidTypeException("SubscriptionPlan is Invalid!");
        }
        return subscription;
    }
}