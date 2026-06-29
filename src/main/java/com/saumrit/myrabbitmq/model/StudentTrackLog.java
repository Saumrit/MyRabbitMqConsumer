package com.saumrit.myrabbitmq.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "StudentTrackingLog")
public class StudentTrackLog {
    public String rollId;
    public String actionTaken;
    public LocalDateTime eventDateTime;
}
