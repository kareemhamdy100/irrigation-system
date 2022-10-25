package org.example.irrigationSystem.DTO;

import javax.validation.constraints.NotNull;

public class PlotConfigDTO {
    @NotNull
    private float timeSlot;
    @NotNull
    private  float amountOfWater;
    @NotNull
    private String moistureSensorId;
    @NotNull
    private  String irrigateSensorId;

    public float getTimeSlot() {
        return timeSlot;
    }

    public float getAmountOfWater() {
        return amountOfWater;
    }

    public String getMoistureSensorId() {
        return moistureSensorId;
    }

    public String getIrrigateSensorId() {
        return irrigateSensorId;
    }
}
