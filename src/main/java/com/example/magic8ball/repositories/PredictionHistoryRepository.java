package com.example.magic8ball.repositories;

import com.example.magic8ball.domain.PredictionsHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PredictionHistoryRepository extends CrudRepository<PredictionsHistory, Integer> {
    Page<PredictionsHistory> findAll(Pageable pageable);
}
