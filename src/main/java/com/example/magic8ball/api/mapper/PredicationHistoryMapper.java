package com.example.magic8ball.api.mapper;

import com.example.magic8ball.api.model.QuestionRespDTO;
import com.example.magic8ball.domain.PredictionsHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PredicationHistoryMapper {
    PredicationHistoryMapper INSTANCE = Mappers.getMapper(PredicationHistoryMapper.class);

    @Mapping(source = "prediction.text", target = "prediction")
    QuestionRespDTO predictionHistoryToQuestionRespDTO(PredictionsHistory predictionsHistory);
}
