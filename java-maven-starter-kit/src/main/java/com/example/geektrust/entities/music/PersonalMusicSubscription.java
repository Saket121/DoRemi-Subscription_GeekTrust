package com.example.geektrust.entities.music;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.entities.Subscription;

public class PersonalMusicSubscription extends Subscription {
    public PersonalMusicSubscription() {
        super.price = Constants.MUSIC_SUBSCRIPTION_PERSONAL_PLAN_PRICE;
        super.validityInMonths = Constants.MUSIC_SUBSCRIPTION_PERSONAL_PLAN_VALIDITY;
    }
}