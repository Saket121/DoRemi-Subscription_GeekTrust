package com.example.geektrust.config;

import com.example.geektrust.commands.AddSubscriptionCommand;
import com.example.geektrust.commands.AddTopUpCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.PrintRenewalDetailsCommand;
import com.example.geektrust.commands.StartSubscriptionCommand;
import com.example.geektrust.entities.DoReMiSubscription;
import com.example.geektrust.services.RenewalService;
import com.example.geektrust.services.RenewalServiceImpl;
import com.example.geektrust.services.SubscriptionService;
import com.example.geektrust.services.SubscriptionServiceImpl;

public class ApplicationConfig {
    private final DoReMiSubscription doReMiSubscription = new DoReMiSubscription();
    private final SubscriptionServiceImpl subscriptionService = new SubscriptionService(doReMiSubscription);
    private final RenewalServiceImpl renewalService = new RenewalService(doReMiSubscription);
    private final StartSubscriptionCommand startSubscriptionCommand = new StartSubscriptionCommand(subscriptionService);
    private final AddSubscriptionCommand addSubscriptionCommand = new AddSubscriptionCommand(subscriptionService);
    private final AddTopUpCommand addTopUpCommand = new AddTopUpCommand(subscriptionService);
    private final PrintRenewalDetailsCommand printRenewalDetailsCommand = new PrintRenewalDetailsCommand(renewalService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("START_SUBSCRIPTION", startSubscriptionCommand);
        commandInvoker.registerCommand("ADD_SUBSCRIPTION", addSubscriptionCommand);
        commandInvoker.registerCommand("ADD_TOPUP", addTopUpCommand);
        commandInvoker.registerCommand("PRINT_RENEWAL_DETAILS", printRenewalDetailsCommand);
        return commandInvoker;
    }

    public DoReMiSubscription getDoReMiSubscription() {
        return doReMiSubscription;
    }

    public SubscriptionServiceImpl getSubscriptionService() {
        return subscriptionService;
    }

    public RenewalServiceImpl getRenewalService() {
        return renewalService;
    }
}