package org.example.irrigationSystem.service;

import org.example.irrigationSystem.enums.PlotStatus;
import org.example.irrigationSystem.models.Plot;
import org.example.irrigationSystem.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SensorInterfaceService {
    @Autowired
    PlotRepository plotRepository;
    @Autowired
    MockService mockService;
    @Autowired
    AsyncTasks asyncTasks;

    public void  irrigateAction(String moistureSensorId){
        Plot plot = plotRepository.findByMoistureSensorId(moistureSensorId);
        boolean isSensorResponse = mockService.mockIrrigateRequest(plot.getIrrigateSensorId());
        plot.setStatus(PlotStatus.PENDING);
        plotRepository.save(plot);
        if(!isSensorResponse) {
            asyncTasks.retryToCallIrrigateSensor(plot.getIrrigateSensorId());
        }
    }
}
