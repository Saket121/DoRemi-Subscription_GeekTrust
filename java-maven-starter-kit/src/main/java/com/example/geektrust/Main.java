package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.config.ApplicationConfig;
import com.example.geektrust.constants.Constants;
import com.example.geektrust.exceptions.NoSuchCommandException;

public class Main {
    public static void main(String[] args) {
        List<String> commandLineArguments = new LinkedList<>(Arrays.asList(args));
        run(commandLineArguments);
    }

    public static void run(List<String> commandLineArgs) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        String inputFileName = commandLineArgs.get(Constants.ZERO);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> listOfTokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(listOfTokens.get(Constants.ZERO), listOfTokens);
            }
        } catch (IOException | NoSuchCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}