package com.example.geektrust.commands;


import java.util.List;

import com.example.geektrust.dto.RenewalAmountDto;
import com.example.geektrust.dto.RenewalReminderDto;
import com.example.geektrust.exceptions.SubscriptionNotFoundException;
import com.example.geektrust.services.RenewalServiceImpl;

public class PrintRenewalDetailsCommand implements CommandImpl {

    private final RenewalServiceImpl renewalService;

    public PrintRenewalDetailsCommand(RenewalServiceImpl renewalService) {
        this.renewalService = renewalService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            List<RenewalReminderDto> renewalReminders = renewalService.calculateListOfRenewalDateOfSubscriptions();
            RenewalAmountDto renewalAmount = renewalService.calculateRenewalAmount();
            
            for (RenewalReminderDto renewalReminder : renewalReminders) {
                System.out.println(renewalReminder.toString());
            }
            
            System.out.println(renewalAmount);
        } catch (SubscriptionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}