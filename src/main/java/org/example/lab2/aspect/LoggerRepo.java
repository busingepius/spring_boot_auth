package org.example.lab2.aspect;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
