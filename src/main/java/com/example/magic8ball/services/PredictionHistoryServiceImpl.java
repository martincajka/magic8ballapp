package com.example.magic8ball.services;

import com.example.magic8ball.api.mapper.PredicationHistoryMapper;
import com.example.magic8ball.api.model.*;
import com.example.magic8ball.domain.Prediction;
import com.example.magic8ball.domain.PredictionsHistory;
import com.example.magic8ball.exceptions.NotFoundException;
import com.example.magic8ball.repositories.PredictionHistoryRepository;
import com.example.magic8ball.repositories.PredictionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PredictionHistoryServiceImpl implements PredictionHistoryService {
    private final PredictionHistoryRepository predictionHistoryRepository;

    private final PredictionRepository predictionRepository;

    private final PredicationHistoryMapper predicationHistoryMapper;

    public PredictionHistoryServiceImpl(PredictionHistoryRepository predictionHistoryRepository, PredictionRepository predictionRepository, PredicationHistoryMapper predicationHistoryMapper) {
        this.predictionHistoryRepository = predictionHistoryRepository;
        this.predictionRepository = predictionRepository;
        this.predicationHistoryMapper = predicationHistoryMapper;
    }

    @Override
    public QuestionsDTO getHistory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PredictionsHistory> allPredictionHistory = predictionHistoryRepository.findAll(pageable);

        PageResultDTO pageResultDTO = new PageResultDTO();
        pageResultDTO.setTotal((int) allPredictionHistory.getTotalElements());
        pageResultDTO.setSize(pageable.getPageSize());
        pageResultDTO.setIndex(pageable.getPageNumber());

        List<QuestionRespDTO> questions = allPredictionHistory.getContent().stream()
                .map(predicationHistoryMapper::predictionHistoryToQuestionRespDTO)
                .toList();

        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setItems(questions);
        questionsDTO.setPage(pageResultDTO);

        return questionsDTO;
    }

    @Override
    public QuestionRespDTO answerQuestion(QuestionReqDTO question) {
        List<Prediction> allPredictions = StreamSupport
                .stream(predictionRepository.findAll().spliterator(), false)
                .toList();
        if (allPredictions.isEmpty()) {
            throw new NotFoundException("No predictions found");
        } else {
            int index = (int) (Math.random() * allPredictions.size()) + 1;
            Prediction prediction = allPredictions.get(index);
            PredictionsHistory predictionsHistory = new PredictionsHistory();
            predictionsHistory.setQuestion(question.getQuestion());
            predictionsHistory.setPrediction(prediction);
            predictionsHistory.setCreatedAt(Instant.now().truncatedTo(ChronoUnit.MILLIS).toString());
            predictionHistoryRepository.save(predictionsHistory);
            return predicationHistoryMapper.predictionHistoryToQuestionRespDTO(predictionsHistory);
        }
    }
}
