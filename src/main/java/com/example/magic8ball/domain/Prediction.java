package com.example.magic8ball.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prediction")
public class Prediction {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String text;
    private String createdAt;
    @OneToMany(mappedBy = "prediction", cascade = CascadeType.ALL)
    private Set<PredictionsHistory> predictionsHistory;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prediction that = (Prediction) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", prediction='" + text + '\'' +
                '}';
    }
}
