package com.example.geektrust.entities.video;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class FreeVideoSubscription extends Subscription {
    public FreeVideoSubscription() {
        super.price = Constants.VIDEO_SUBSCRIPTION_FREE_PLAN_PRICE;
        super.validityInMonths = Constants.VIDEO_SUBSCRIPTION_FREE_PLAN_VALIDITY;
    }
}