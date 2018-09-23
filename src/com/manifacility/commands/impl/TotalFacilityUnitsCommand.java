package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.models.Facility;

/**
 * Show total produced units by all machines
 */
public class TotalFacilityUnitsCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "total";

    public TotalFacilityUnitsCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {
        if(commandString != null) {
            this.facility.total();
            return true;
        }
        return false;
    }
}
