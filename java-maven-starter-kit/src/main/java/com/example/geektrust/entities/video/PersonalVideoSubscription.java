package com.example.geektrust.entities.video;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PersonalVideoSubscription extends Subscription {
    public PersonalVideoSubscription() {
        super.price = Constants.VIDEO_SUBSCRIPTION_PERSONAL_PLAN_PRICE;
        super.validityInMonths = Constants.VIDEO_SUBSCRIPTION_PERSONAL_PLAN_VALIDITY;
    }
}