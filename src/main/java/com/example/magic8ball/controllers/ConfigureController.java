package com.example.magic8ball.controllers;

import com.example.magic8ball.api.model.PredicationsDTO;
import com.example.magic8ball.api.model.PredictionDTO;
import com.example.magic8ball.services.PredictionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConfigureController {
    private final PredictionService predictionService;

    public ConfigureController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/ball/prediction/{id}")
    public @ResponseBody PredictionDTO getPrediction(@PathVariable int id) {
        return predictionService.getPrediction(id);
    }

    @GetMapping("/ball/prediction")
    public @ResponseBody PredicationsDTO getPredictions(@RequestParam int pageIndex, @RequestParam int pageSize) {
        return predictionService.getPredictions(pageIndex, pageSize);
    }

    @PostMapping("/ball/prediction")
    public @ResponseBody PredictionDTO addPrediction(@RequestBody PredictionDTO prediction) {
        return predictionService.addPrediction(prediction);
    }

    @DeleteMapping("/ball/prediction/{id}")
    public @ResponseBody PredictionDTO deletePrediction(@PathVariable int id) {
        return predictionService.deletePrediction(id);
    }

    @PutMapping("/ball/prediction/{id}")
    public @ResponseBody PredictionDTO updatePrediction(@PathVariable int id, @RequestBody PredictionDTO prediction) {
        return predictionService.updatePrediction(id, prediction);
    }
}
