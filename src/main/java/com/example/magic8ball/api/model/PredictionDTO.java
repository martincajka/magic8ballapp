package com.example.magic8ball.api.model;

import lombok.Data;

@Data
public class PredictionDTO {
    public int id;
    public String text;
    public String createdAt;
}
