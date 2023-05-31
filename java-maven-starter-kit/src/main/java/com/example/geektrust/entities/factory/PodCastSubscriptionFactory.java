package com.example.geektrust.entities.factory;

import com.example.geektrust.entities.Subscription;
import com.example.geektrust.entities.podcast.FreePodCastSubscription;
import com.example.geektrust.entities.podcast.PersonalPodCastSubscription;
import com.example.geektrust.entities.podcast.PremiumPodCastSubscription;
import com.example.geektrust.enums.SubscriptionPlan;

public class PodCastSubscriptionFactory extends AbstractFactory {
    @Override
    Subscription getSubscriptionPlan(SubscriptionPlan subscriptionPlanType) {
        switch (subscriptionPlanType) {
            case FREE:
                return new FreePodCastSubscription();
            case PERSONAL:
                return new PersonalPodCastSubscription();
            case PREMIUM:
                return new PremiumPodCastSubscription();
            default:
                return null;
        }
    }
}