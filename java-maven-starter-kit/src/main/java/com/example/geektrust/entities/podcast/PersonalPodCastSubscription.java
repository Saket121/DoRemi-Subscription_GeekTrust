package com.example.geektrust.entities.podcast;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PersonalPodCastSubscription extends Subscription {
    public PersonalPodCastSubscription() {
        super.price = Constants.PODCAST_SUBSCRIPTION_PERSONAL_PLAN_PRICE;
        super.validityInMonths = Constants.PODCAST_SUBSCRIPTION_PERSONAL_PLAN_VALIDITY;
    }
}