package com.saumrit.myrabbitmq.controller;

import com.saumrit.myrabbitmq.service.MyRabbitMqProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/v1")
public class MyRabbitMqController {

    public  final MyRabbitMqProducerService myRabbitMqProducerService;

    public MyRabbitMqController(MyRabbitMqProducerService myRabbitMqProducerService) {
        this.myRabbitMqProducerService = myRabbitMqProducerService;
    }

    @Operation(summary = "Api to send message to RabbitMq",
            description = "Api to send message to RabbitMq")
    @PostMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Success"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error") })
    public void sendMessageController(){
        myRabbitMqProducerService.sendMessage("dewdewd");
    }
}
