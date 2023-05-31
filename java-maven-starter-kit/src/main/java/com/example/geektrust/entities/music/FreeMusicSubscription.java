package com.example.geektrust.entities.music;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class FreeMusicSubscription extends Subscription {
    public FreeMusicSubscription() {
        super.price = Constants.MUSIC_SUBSCRIPTION_FREE_PLAN_PRICE;
        super.validityInMonths = Constants.MUSIC_SUBSCRIPTION_FREE_PLAN_VALIDITY;
    }
}
