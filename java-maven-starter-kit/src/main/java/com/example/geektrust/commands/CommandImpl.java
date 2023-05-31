package com.example.geektrust.commands;

import java.util.List;

/**
 * Interface for executing commands.
 */
public interface CommandImpl {
    /**
     * Execute the command with the given tokens.
     *
     * @param tokens The tokens for the command.
     */
    void execute(List<String> tokens);
}
