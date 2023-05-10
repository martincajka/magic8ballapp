package com.example.magic8ball.api.mapper;

import com.example.magic8ball.api.model.PredictionDTO;
import com.example.magic8ball.domain.Prediction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PredictionMapper {
    PredictionMapper INSTANCE = Mappers.getMapper(PredictionMapper.class);


    PredictionDTO predictionToPredictionDTO(Prediction prediction);

    Prediction predictionDTOToPrediction(PredictionDTO prediction);
}
