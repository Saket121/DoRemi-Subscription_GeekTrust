package com.example.geektrust.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.enums.SubscriptionCategory;

public class RenewalReminderDto {
    private final SubscriptionCategory subscriptionCategory;
    private final LocalDate renewalDate;

    public RenewalReminderDto(LocalDate renewalDate, SubscriptionCategory subscriptionCategory) {
        this.renewalDate = renewalDate;
        this.subscriptionCategory = subscriptionCategory;
    }

    @Override
    public String toString() {
        String formattedDate = renewalDate.format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
        return "RENEWAL_REMINDER " + subscriptionCategory + " " + formattedDate;
    }
}
