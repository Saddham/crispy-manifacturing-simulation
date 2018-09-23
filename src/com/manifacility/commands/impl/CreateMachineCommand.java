package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Create a machine; A machine has a name and a unique Id
 */
public class CreateMachineCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "create";

    public CreateMachineCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {
        if (commandString != null) {
            String filtered = commandString
                    .replace(CMDSTRING,"")
                    .replaceAll("\\s","");
            String id = filtered
                    .substring(filtered.length()-9);
            String name = filtered
                    .substring(0, filtered.length()-9);
            try {
                this.facility.create(id, name);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
