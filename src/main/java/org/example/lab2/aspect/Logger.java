package org.example.lab2.aspect;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_Id;
    private LocalDateTime dateTime;
    private String principle;
    private String operation;

    public Logger(LocalDateTime dateTime, String principle, String operation) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
    }
}
