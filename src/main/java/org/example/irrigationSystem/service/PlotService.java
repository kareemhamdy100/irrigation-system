package org.example.irrigationSystem.service;

import org.example.irrigationSystem.DTO.PlotConfigDTO;
import org.example.irrigationSystem.repository.PlotRepository;
import org.example.irrigationSystem.models.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlotService {

    @Autowired
    private PlotRepository plotRepository;

    public List<Plot> getAllPlots(){
        return  plotRepository.findAll();
    }

    public Plot createPlot(Plot newPlot){
        return  plotRepository.insert(newPlot);
    }

    public void configPlot(PlotConfigDTO plotConfig, String plotId){
       Plot plot =  plotRepository.findById(plotId).get();
       plot.setAmountOfWater(plotConfig.getAmountOfWater());
       plot.setTimeSlot(plotConfig.getTimeSlot());
       plot.setMoistureSensorId(plotConfig.getMoistureSensorId());
       plot.setIrrigateSensorId(plotConfig.getIrrigateSensorId());
       plotRepository.save(plot);
    }
}
