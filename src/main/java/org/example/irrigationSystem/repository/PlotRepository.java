package org.example.irrigationSystem.repository;

import org.example.irrigationSystem.models.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends MongoRepository<Plot, String> {

    Plot findByMoistureSensorId(String moistureSensorId);
}
