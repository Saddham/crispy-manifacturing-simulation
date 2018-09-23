package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Tracks and sets how many units are produced by each machine
 */
public class AddUnitsCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "add";

    public AddUnitsCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {

        // ******************************************************
        // Filtering the command string and extracting infos from
        // ******************************************************
        if(commandString != null) {
            String id = commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","")
                    .substring(0,9);
            int units = Integer.parseInt(commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","")
                    .replace(id,""));

            try {
                this.facility.add(id,units);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
