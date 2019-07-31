package com.gabryelrock.poc.kafka_camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Message extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:test?brokers=localhost:9092")
                .log("Message received from Kafka : ${body}");
    }
}
