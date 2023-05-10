package com.example.magic8ball.services;

import com.example.magic8ball.api.mapper.PredictionMapper;
import com.example.magic8ball.api.model.PageResultDTO;
import com.example.magic8ball.api.model.PredicationsDTO;
import com.example.magic8ball.api.model.PredictionDTO;
import com.example.magic8ball.domain.Prediction;
import com.example.magic8ball.exceptions.NotFoundException;
import com.example.magic8ball.repositories.PredictionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    private final PredictionRepository predictionRepository;
    private final PredictionMapper predictionMapper;

    public PredictionServiceImpl(PredictionRepository predictionRepository, PredictionMapper predictionMapper) {
        this.predictionRepository = predictionRepository;
        this.predictionMapper = predictionMapper;
    }

    @Override
    public PredicationsDTO getPredictions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<PredictionDTO> predictions;
        Page<Prediction> allPredictions = predictionRepository.findAll(pageable);

        PageResultDTO pageResultDTO = new PageResultDTO();
        pageResultDTO.setTotal((int) allPredictions.getTotalElements());
        pageResultDTO.setSize(pageable.getPageSize());
        pageResultDTO.setIndex(pageable.getPageNumber());

        predictions = allPredictions.getContent().stream()
                .map(predictionMapper::predictionToPredictionDTO)
                .toList();

        PredicationsDTO predicationsDTO = new PredicationsDTO();
        predicationsDTO.setItems(predictions);
        predicationsDTO.setPage(pageResultDTO);

        return predicationsDTO;
    }

    @Override
    public PredictionDTO addPrediction(PredictionDTO prediction) {
        Prediction savedPrediction = predictionRepository.save(predictionMapper.predictionDTOToPrediction(prediction));
        return predictionMapper.predictionToPredictionDTO(savedPrediction);
    }

    @Override
    public PredictionDTO getPrediction(int id) {
        Prediction prediction = predictionRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Prediction not found"));
        return predictionMapper.predictionToPredictionDTO(prediction);

    }

    @Override
    public PredictionDTO deletePrediction(int id) {
        Prediction prediction = predictionRepository.findById(id).orElseThrow(() -> new NotFoundException("Prediction not found"));
        predictionRepository.deleteById(id);
        return predictionMapper.predictionToPredictionDTO(prediction);
    }

    @Override
    public PredictionDTO updatePrediction(int id, PredictionDTO prediction) {
        Prediction predictionToUpdate = predictionRepository.findById(id).orElse(null);
        if (predictionToUpdate != null) {
            predictionToUpdate.setText(prediction.getText());
            predictionToUpdate.setCreatedAt(prediction.getCreatedAt());
            predictionRepository.save(predictionToUpdate);
        }
        return predictionMapper.predictionToPredictionDTO(predictionToUpdate);
    }
}
