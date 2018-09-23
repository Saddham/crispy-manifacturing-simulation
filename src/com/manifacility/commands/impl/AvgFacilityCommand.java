package com.manifacility.commands.impl;

import com.manifacility.commands.MachineCommand;
import com.manifacility.models.Facility;

/**
 * Show average produced units by all machines
 */
public class AvgFacilityCommand implements MachineCommand {

    private Facility facility;
    private final String CMDSTRING = "average";

    public AvgFacilityCommand(Facility facility) { this.facility = facility; }

    @Override
    public boolean execute(String commandString) {
        if(commandString != null) {
            this.facility.averagePerMachines();
            return true;
        }
        return false;
    }
}
