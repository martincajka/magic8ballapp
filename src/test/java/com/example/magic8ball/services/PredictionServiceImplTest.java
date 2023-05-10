package com.example.magic8ball.services;

import com.example.magic8ball.api.mapper.PredictionMapper;
import com.example.magic8ball.api.model.PredicationsDTO;
import com.example.magic8ball.api.model.PredictionDTO;
import com.example.magic8ball.domain.Prediction;
import com.example.magic8ball.repositories.PredictionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PredictionServiceImplTest {

    PredictionServiceImpl predictionService;
    PredictionMapper predictionMapper;

    @Mock
    PredictionRepository predictionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        predictionMapper = PredictionMapper.INSTANCE;
        predictionService = new PredictionServiceImpl(predictionRepository,predictionMapper);
    }

    @Test
    void getPrediction() {
        PredictionDTO prediction = new PredictionDTO();
        prediction.setId(1);
        prediction.setText("Test prediction");
        prediction.setCreatedAt("2021-09-01T00:00:00.000Z");

        when(predictionRepository.findById(1)).thenReturn(Optional.of(predictionMapper.predictionDTOToPrediction(prediction)));

        PredictionDTO predictionDTO = predictionService.getPrediction(1);

        assertThat(predictionService.getPrediction(1), notNullValue());
        assertEquals(predictionDTO.getId(), prediction.getId());
        assertEquals(predictionDTO.getText(), prediction.getText());
        assertEquals(predictionDTO.getCreatedAt(), prediction.getCreatedAt());
    }

    @Test
    void getPredictions() {
    }

    @Test
    void addPrediction() {
    }

    @Test
    void deletePrediction() {
    }

    @Test
    void updatePrediction() {
    }
}