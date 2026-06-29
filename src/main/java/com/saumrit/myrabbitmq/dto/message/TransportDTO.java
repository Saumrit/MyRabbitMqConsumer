package com.saumrit.myrabbitmq.dto.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransportDTO {
    public String rollId;
    public LocalDateTime eventDateTime;
}
