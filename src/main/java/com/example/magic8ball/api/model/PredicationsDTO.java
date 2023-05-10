package com.example.magic8ball.api.model;

import lombok.Data;

import java.util.List;

@Data
public class PredicationsDTO {
    List<PredictionDTO> items;
    PageResultDTO page;
}
