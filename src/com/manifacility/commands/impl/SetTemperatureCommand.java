package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.logging.ManifLoggerSpec;
import com.manifacility.models.Facility;

/**
 * Sets machines temperature
 */
public class SetTemperatureCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "temperature";

    public SetTemperatureCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {

        if(commandString != null) {
            String id = commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","")
                    .substring(0,9);
            int temperature = Integer.parseInt(commandString
                    .replace(CMDSTRING, "")
                    .replaceAll("\\s","")
                    .replace(id,""));
            try {
                this.facility.temperature(id,temperature);
            } catch(NullPointerException e) {
                ManifLoggerSpec.log(e);
            }
            return true;
        }
        return false;
    }
}
