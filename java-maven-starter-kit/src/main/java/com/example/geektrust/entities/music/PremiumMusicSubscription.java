package com.example.geektrust.entities.music;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PremiumMusicSubscription extends Subscription {
    public PremiumMusicSubscription() {
        super.price = Constants.MUSIC_SUBSCRIPTION_PREMIUM_PLAN_PRICE;
        super.validityInMonths = Constants.MUSIC_SUBSCRIPTION_PREMIUM_PLAN_VALIDITY;
    }
}