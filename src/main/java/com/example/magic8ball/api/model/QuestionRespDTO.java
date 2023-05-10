package com.example.magic8ball.api.model;

import lombok.Data;

@Data
public class QuestionRespDTO {
    int id;
    String question;
    String prediction;
    String createdAt;
}
