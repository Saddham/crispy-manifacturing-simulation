package com.manifacility.main;

import com.manifacility.commands.MachineCommandExecutor;
import com.manifacility.commands.impl.*;
import com.manifacility.models.Facility;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Facility facility = new Facility();
        MachineCommandExecutor machineCommandExecutor = new MachineCommandExecutor();
        System.out.println("-- Welcome to IDEAX: your Manifacturing facility --\n You're in command now..\n");

        final Pattern CREATE_PATTERN = Pattern.compile("(create [A-Z]*[0-9]* IDX[0-9]{6})");
        final Pattern ADD_PATTERN = Pattern.compile("(add IDX[0-9]{6} [0-9]*)");
        final Pattern TEMP_SET_PATTERN = Pattern.compile("(temperature IDX[0-9]{6} [0-9]*)");
        final Pattern TEMP_GET_PATTERN = Pattern.compile("(temperature IDX[0-9]{6})");
        final Pattern TOTAL_PATTERN = Pattern.compile("(total IDX[0-9]{6})");
        final Pattern TOTAL_FACILITY_PATTERN = Pattern.compile("(total)");
        final Pattern AVG_PATTERN = Pattern.compile("(average IDX[0-9]{6})");
        final Pattern AVG_FACILITY_PATTERN = Pattern.compile("(average)");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String commandString = scanner.nextLine();

            if (CREATE_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new CreateMachineCommand(facility),commandString);
            } else if (ADD_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new AddUnitsCommand(facility),commandString);
            } else if (TEMP_SET_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new SetTemperatureCommand(facility),commandString);
            } else if (TEMP_GET_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new GetTemperatureCommand(facility),commandString);
            } else if (TOTAL_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new TotalMachineUnitsCommand(facility),commandString);
            } else if (TOTAL_FACILITY_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new TotalFacilityUnitsCommand(facility),commandString);
            } else if (AVG_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new AvgCommand(facility),commandString);
            } else if (AVG_FACILITY_PATTERN.matcher(commandString).matches()) {
                machineCommandExecutor.executeCommand(new AvgFacilityCommand(facility),commandString);
            } else {
                System.out.println("Invalid command.. Exiting");
                break;
            }
        }

    }
}