package com.example.magic8ball.repositories;

import com.example.magic8ball.domain.Prediction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PredictionRepository extends CrudRepository<Prediction, Integer> {
    Page<Prediction> findAll(Pageable pageable);
}
