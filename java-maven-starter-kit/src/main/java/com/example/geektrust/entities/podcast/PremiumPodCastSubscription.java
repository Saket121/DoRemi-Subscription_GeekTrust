package com.example.geektrust.entities.podcast;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PremiumPodCastSubscription extends Subscription {
    public PremiumPodCastSubscription() {
        super.price = Constants.PODCAST_SUBSCRIPTION_PREMIUM_PLAN_PRICE;
        super.validityInMonths = Constants.PODCAST_SUBSCRIPTION_PREMIUM_PLAN_VALIDITY;
    }
}
