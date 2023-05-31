package com.example.geektrust.entities.video;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PremiumVideoSubscription extends Subscription {
    public PremiumVideoSubscription() {
        super.price = Constants.VIDEO_SUBSCRIPTION_PREMIUM_PLAN_PRICE;
        super.validityInMonths = Constants.VIDEO_SUBSCRIPTION_PREMIUM_PLAN_VALIDITY;
    }
}