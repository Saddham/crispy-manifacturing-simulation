package com.manifacility.models;

import java.util.Hashtable;
import java.util.Set;

public class Facility {

    // Even if it's not the best structure in term of performance
    // (for its thread safety per example) but it suits us to avoid
    // null values, null keys and duplicates for example
    private Hashtable<String, Machine> machines = new Hashtable<>();

    public void create(String id, String name) {
        this.machines.put(id, new Machine(name));
        System.out.println("Machine " + id + " created and added to the facility successfully");
    }

    public void add(String id, int units) throws NullPointerException {
        this.machines.get(id).addUnits(units);
        System.out.println("Machine " + id + " produced " + units + " units successfully");
    }

    public void temperature(String id, int temperature) throws NullPointerException {
        this.machines.get(id).setTemperature(temperature);
        System.out.println("Temperature set to " + temperature + " successfully");
    }

    public void temperature(String id) throws NullPointerException {
        System.out.println(this.machines.get(id).getTemperature());
    }

    public void total(String id) throws NullPointerException {
        System.out.println(this.machines.get(id).total());
    }

    public void total() {
        Set<String> keys = this.machines.keySet();
        System.out.println(keys.stream().mapToInt(k -> this.machines.get(k).total()).sum());
    }

    public int average(String id) {
        Machine machineConcerned = this.machines.get(id);
        System.out.println(machineConcerned.total() / machineConcerned.getProductionTimes());
        return machineConcerned.total() / machineConcerned.getProductionTimes();
    }

    public void averagePerMachines() {
        Set<String> keys = this.machines.keySet();
        System.out.println(keys.stream().mapToInt(this::average).sum() / this.machines.size());
    }

}
