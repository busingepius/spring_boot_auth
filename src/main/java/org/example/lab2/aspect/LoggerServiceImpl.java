package org.example.lab2.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{

    @Autowired
    private LoggerRepo loggerRepo;
    @Override
    public void addLog(Logger log) {
        loggerRepo.save(log);
    }
}
