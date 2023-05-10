package com.example.magic8ball.services;

import com.example.magic8ball.api.model.QuestionReqDTO;
import com.example.magic8ball.api.model.QuestionRespDTO;
import com.example.magic8ball.api.model.QuestionsDTO;
import org.springframework.stereotype.Service;

@Service
public interface PredictionHistoryService {
    QuestionsDTO getHistory(int page, int size);

    QuestionRespDTO answerQuestion(QuestionReqDTO question);
}
