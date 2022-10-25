package org.example.irrigationSystem.controller;


import org.example.irrigationSystem.DTO.PlotConfigDTO;
import org.example.irrigationSystem.service.PlotService;
import org.example.irrigationSystem.models.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(value =  "api/plot")
public class PlotController {

    @Autowired
    private PlotService plotService;
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Plot>> getAllPlots(){
        List<Plot> allPlots = plotService.getAllPlots();
        return  new ResponseEntity<>(allPlots, HttpStatus.OK);
    }

    @PostMapping(value =  {"", "/"})
    public  ResponseEntity<Plot> createPlot(@Valid @RequestBody Plot body){
        Plot  createdPlot = plotService.createPlot(body);
        return  new ResponseEntity<>( createdPlot, HttpStatus.CREATED);
    }

    @PutMapping(value =  "/{plotId}")
    public  ResponseEntity<String> updatePlot(@Valid @RequestBody PlotConfigDTO body , @PathVariable String plotId){
      try {
          plotService.configPlot(body, plotId);
          return new ResponseEntity<>(HttpStatus.OK);
      }catch (Exception e){
          return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
    }
}
