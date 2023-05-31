package com.example.geektrust.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.exceptions.NoSuchCommandException;

public class CommandInvoker {
    private static final Map<String, CommandImpl> commandMap = new HashMap<>();

    /**
     * Register a command with the command name.
     *
     * @param commandName The name of the command.
     * @param command     The command to register.
     */
    public void registerCommand(String commandName, CommandImpl command) {
        commandMap.put(commandName, command);
    }

    /**
     * Get the command associated with the command name.
     *
     * @param commandName The name of the command.
     * @return The command associated with the command name, or null if not found.
     */
    private CommandImpl getCommand(String commandName) {
        return commandMap.get(commandName);
    }

    /**
     * Execute the command with the given name and tokens.
     *
     * @param commandName The name of the command to execute.
     * @param tokens      The tokens for the command.
     * @throws NoSuchCommandException If the command is not found.
     */
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        CommandImpl command = getCommand(commandName);
        if (command == null) {
            throw new NoSuchCommandException("No Command Found!");
        }
        command.execute(tokens);
    }
}