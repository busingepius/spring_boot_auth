package org.example.lab2.exception;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Exceptionn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_Id;
    private LocalDateTime dateTime;
    private String principle;
    private String operation;
    private String exception;

    public Exceptionn(LocalDateTime dateTime, String principle, String operation, String exception) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
        this.exception = exception;
    }
}
