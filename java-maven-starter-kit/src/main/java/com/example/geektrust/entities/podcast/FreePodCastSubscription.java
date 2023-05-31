package com.example.geektrust.entities.podcast;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class FreePodCastSubscription extends Subscription {
    public FreePodCastSubscription() {
        super.price = Constants.PODCAST_SUBSCRIPTION_FREE_PLAN_PRICE;
        super.validityInMonths = Constants.PODCAST_SUBSCRIPTION_FREE_PLAN_VALIDITY;
    }
}