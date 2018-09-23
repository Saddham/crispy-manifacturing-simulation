package com.manifacility.commands;

/**
 * The invoker class for the Command design pattern
 * for all 'MachineCommand' commands.
 * Some sort of abstraction to decouple the
 * commands from their consumers.
 */
public class MachineCommandExecutor {
    public boolean executeCommand(MachineCommand machineCommand, String commandString) {
        return machineCommand.execute(commandString);
    }
}
