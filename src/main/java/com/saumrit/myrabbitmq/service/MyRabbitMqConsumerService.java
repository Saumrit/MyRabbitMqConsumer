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

    public void saveLogForStudent(TransportDTO transportDTO,String action) throws Exception {
        StudentTrackLog studentTrackLog= objectMapper.convertValue(transportDTO, StudentTrackLog.class);
        studentTrackLog.setActionTaken(action);

//        if(transportDTO.getRollId().contains("J")|| transportDTO.getRollId().contains("K") || transportDTO.getRollId().contains("L"))
//            throw new Exception("");
        if(6 == transportDTO.getRollId().length())
            throw new RuntimeException("Here is the Exception :"+ transportDTO.getRollId());
        studentTrackingLogFRepository.save(studentTrackLog);
        //return true;
    }
}
