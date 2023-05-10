package com.example.magic8ball.controllers;

import com.example.magic8ball.api.model.QuestionReqDTO;
import com.example.magic8ball.api.model.QuestionRespDTO;
import com.example.magic8ball.api.model.QuestionsDTO;
import com.example.magic8ball.services.PredictionHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AskController {
    private final PredictionHistoryService predictionHistoryService;

    public AskController(PredictionHistoryService predictionHistoryService) {
        this.predictionHistoryService = predictionHistoryService;
    }

    @PostMapping("/ball/ask")
    public @ResponseBody QuestionRespDTO ask(@RequestBody QuestionReqDTO questionReqDTO) {
        return predictionHistoryService.answerQuestion(questionReqDTO);
    }



    @GetMapping("/ball/history")
    public @ResponseBody QuestionsDTO history(@RequestParam int pageIndex, @RequestParam int pageSize) {
        return predictionHistoryService.getHistory(pageIndex, pageSize);
    }
}
