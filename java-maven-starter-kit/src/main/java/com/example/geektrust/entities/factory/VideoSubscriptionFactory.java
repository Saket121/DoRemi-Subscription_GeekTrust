package com.example.geektrust.entities.factory;

import com.example.geektrust.entities.Subscription;
import com.example.geektrust.entities.video.FreeVideoSubscription;
import com.example.geektrust.entities.video.PersonalVideoSubscription;
import com.example.geektrust.entities.video.PremiumVideoSubscription;
import com.example.geektrust.enums.SubscriptionPlan;

public class VideoSubscriptionFactory extends AbstractFactory {
    @Override
    Subscription getSubscriptionPlan(SubscriptionPlan subscriptionPlanType) {
        switch (subscriptionPlanType) {
            case FREE:
                return new FreeVideoSubscription();
            case PERSONAL:
                return new PersonalVideoSubscription();
            case PREMIUM:
                return new PremiumVideoSubscription();
            default:
                return null;
        }
    }
}