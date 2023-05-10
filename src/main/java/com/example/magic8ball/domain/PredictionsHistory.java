package com.example.magic8ball.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_history")
public class PredictionsHistory {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String createdAt;
    @ManyToOne
    private Prediction prediction;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PredictionsHistory that = (PredictionsHistory) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "QuestionHistory{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", prediction=" + prediction +
                '}';
    }
}
