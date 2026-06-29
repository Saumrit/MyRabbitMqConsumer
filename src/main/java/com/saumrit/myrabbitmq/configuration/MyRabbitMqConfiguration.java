package com.saumrit.myrabbitmq.configuration;

import com.saumrit.myrabbitmq.dto.message.TransportDTO;
import com.saumrit.myrabbitmq.service.MyRabbitMqConsumerService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MyRabbitMqConfiguration {

    public final MyRabbitMqConsumerService myRabbitMqConsumerService;

    public MyRabbitMqConfiguration(MyRabbitMqConsumerService myRabbitMqConsumerService) {
        this.myRabbitMqConsumerService = myRabbitMqConsumerService;
    }

//    @Bean
//    public TopicExchange eduExchange() {
//        return new TopicExchange("edu");
//    }

    // 2. Define the Queue
//    @Bean
//    public Queue studentQueue() {
//        Queue queue= new Queue("student.add.queue", true); // true = durable queue
//
//        return queue;
//    }

    // 3. Bind them together using your Routing Key
//    @Bean
//    public Binding binding(Queue studentQueue, TopicExchange eduExchange) {
//        return BindingBuilder.bind(studentQueue)
//                .to(eduExchange)
//                .with("saumrit.edu.student.add")
//                ;
//    }
    @Bean
    @ConfigurationProperties(value = "spring.cloud.function.definition")
    public Consumer<TransportDTO> consumerstudentadd(){
        return x -> {
            boolean isSaved=myRabbitMqConsumerService.saveLogForStudent(x,"add");
            if(isSaved)
                System.out.println("Entered Roll id is "+x.getRollId()+" at "+ x.getEventDateTime());
        };
    }
}
