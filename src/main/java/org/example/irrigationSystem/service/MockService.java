package org.example.irrigationSystem.service;

import org.springframework.stereotype.Service;

@Service
public class MockService {
    public Boolean mockIrrigateRequest(String sensorId){
        boolean sensorAvailable = Math.random() < 0.4;
        System.out.println("CALL Irrigate Sensor " + (sensorAvailable ? "Success" : "Fail") );
        return  sensorAvailable;
    }

}
