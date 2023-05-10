package com.example.magic8ball.services;

import com.example.magic8ball.api.model.PredicationsDTO;
import com.example.magic8ball.api.model.PredictionDTO;
import org.springframework.stereotype.Service;

@Service
public interface PredictionService {
    PredicationsDTO getPredictions(int page, int size);

    PredictionDTO addPrediction(PredictionDTO prediction);

    PredictionDTO getPrediction(int id);

    PredictionDTO deletePrediction(int id);

    PredictionDTO updatePrediction(int id, PredictionDTO prediction);
}
