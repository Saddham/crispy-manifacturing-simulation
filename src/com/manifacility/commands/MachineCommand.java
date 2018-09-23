package com.manifacility.commands;

/**
 * The Command classes functional interface
 * to implement whenever a command is created.
 * Enables the use of object-functional implementation
 * of the Command design pattern.
 */
@FunctionalInterface
public interface MachineCommand{

    /**
     * @param commandString
     * @return boolean : can be used later
     * to implement the exit status definition
     */
    boolean execute(String commandString);
}