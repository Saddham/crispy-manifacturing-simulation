package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Show average produced units by machine with id specified in call
 */
public class AvgCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "average";

    public AvgCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {
        if(commandString != null) {
            String id = commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","");
            try {
                this.facility.average(id);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
