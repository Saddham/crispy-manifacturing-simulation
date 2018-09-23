package com.manifacility.models;

public class Machine {

    private String name;
    private int productionTimes;
    private int unitsProduced;
    private int temperature;

    public Machine(String name) {
        this.name = name;
        this.unitsProduced = 0;
        this.productionTimes = 0;
        this.temperature = 0;
    }

    public void addUnits(int units) {
        this.unitsProduced += units;
        this.productionTimes ++;
    }

    public int total() {
        return this.unitsProduced;
    }

    public Machine(String name, int unitsProduced, int temperature) {
        this.name = name;
        this.unitsProduced = unitsProduced;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitsProduced() {
        return unitsProduced;
    }

    public void setUnitsProduced(int unitsProduced) {
        this.unitsProduced = unitsProduced;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getProductionTimes() {
        return productionTimes;
    }

    public void setProductionTimes(int productionTimes) {
        this.productionTimes = productionTimes;
    }

}
