package org.example.irrigationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTasks {

    @Autowired
    private  MockService mockService;
    @Value("${spring.application.sensor-call-retries-count}")
    private  int  SENSOR_CALL_RETRIES_COUNT ;
    @Value("${spring.application.sensor-call-retry-interval}")
    private int SENSOR_CALL_RETRY_INTERVAL;

    @Async
    public void retryToCallIrrigateSensor(String irrigateSensorId){
        try {
            boolean isSensorAvailable = mockService.mockIrrigateRequest(irrigateSensorId);
            int retryCount = SENSOR_CALL_RETRIES_COUNT;
            while (retryCount > 0 && !isSensorAvailable){
                System.out.println(retryCount);
                Thread.sleep(SENSOR_CALL_RETRY_INTERVAL);
                isSensorAvailable = mockService.mockIrrigateRequest(irrigateSensorId);
                retryCount--;
            }
            if(retryCount == 0){
                System.out.println("CALL ALERT SYSTEM");
            }else{

                System.out.println("Sensor Is available ");
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
