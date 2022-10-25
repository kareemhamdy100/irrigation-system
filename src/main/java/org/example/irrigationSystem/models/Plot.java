package org.example.irrigationSystem.models;

import org.example.irrigationSystem.enums.PlotStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Plot")
public class Plot {
    @Id
    private  String id;
    private float timeSlot;
    private  float amountOfWater;
    private String moistureSensorId;
    private  String irrigateSensorId;

    private PlotStatus status = PlotStatus.IDEAL;
    private long createdAt;
    public Plot() {
        this.createdAt = System.currentTimeMillis();
    }



    public Plot(String id, float timeSlot, float amountOfWater, String moistureSensorId, String irrigateSensorId, PlotStatus status, long createdAt) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.amountOfWater = amountOfWater;
        this.moistureSensorId = moistureSensorId;
        this.irrigateSensorId = irrigateSensorId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public void setTimeSlot(float timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setAmountOfWater(float amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public void setMoistureSensorId(String moistureSensorId) {
        this.moistureSensorId = moistureSensorId;
    }

    public void setIrrigateSensorId(String irrigateSensorId) {
        this.irrigateSensorId = irrigateSensorId;
    }

    public PlotStatus getStatus() {
        return status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setStatus(PlotStatus status) {
        this.status = status;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "Id='" + id + '\'' +
                ", timeSlot=" + timeSlot +
                ", amountOfWater=" + amountOfWater +
                ", moistureSensorId='" + moistureSensorId + '\'' +
                ", irrigateSensorId='" + irrigateSensorId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
