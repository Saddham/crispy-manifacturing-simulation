package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Track machines temperature
 */
public class GetTemperatureCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "temperature";

    public GetTemperatureCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {
        if(commandString != null) {
            String id = commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","");
            try {
                this.facility.temperature(id);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
