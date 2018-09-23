package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Show total produced units by a specific machine
 */
public class TotalMachineUnitsCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "total";

    public TotalMachineUnitsCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {

        if(commandString != null) {
            String id = commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","");
            try {
                this.facility.total(id);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
