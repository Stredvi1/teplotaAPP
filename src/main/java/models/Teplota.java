package models;

import models.interfaces.ITeplota;

public class Teplota implements ITeplota {

    public final int dayIndex;
    private double temperature;

    public Teplota(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public int getDay() {
        return dayIndex;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return dayIndex + ".   |   " + String.format("%.1f", temperature) + "°C";
    }
}
