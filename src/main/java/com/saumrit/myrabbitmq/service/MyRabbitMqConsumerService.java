package com.saumrit.myrabbitmq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saumrit.myrabbitmq.StudentTrackingLogFRepository;
import com.saumrit.myrabbitmq.dto.message.TransportDTO;
import com.saumrit.myrabbitmq.model.StudentTrackLog;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitMqConsumerService {

    public final StudentTrackingLogFRepository studentTrackingLogFRepository;
    public final ObjectMapper objectMapper;

    public MyRabbitMqConsumerService(StudentTrackingLogFRepository studentTrackingLogFRepository, ObjectMapper objectMapper) {
        this.studentTrackingLogFRepository = studentTrackingLogFRepository;
        this.objectMapper = objectMapper;
    }

    public boolean saveLogForStudent(TransportDTO transportDTO,String action){
        StudentTrackLog studentTrackLog= objectMapper.convertValue(transportDTO, StudentTrackLog.class);
        studentTrackLog.setActionTaken(action);
        studentTrackingLogFRepository.save(studentTrackLog);
        return true;
    }
}
