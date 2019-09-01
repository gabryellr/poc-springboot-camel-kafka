package com.gabryelrock.poc.kafka_camel;

import com.gabryelrock.poc.kafka_camel.predicate.ApplePredicate;
import com.gabryelrock.poc.kafka_camel.predicate.OrangePredicate;
import com.gabryelrock.poc.kafka_camel.processors.AppleProcessor;
import com.gabryelrock.poc.kafka_camel.processors.IsNotAFruitProcessor;
import com.gabryelrock.poc.kafka_camel.processors.OrangeProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class FruitsRoute {

    @Component
    public static class Message extends RouteBuilder {

        @Autowired
        private OrangeProcessor orangeProcessor;

        @Autowired
        private OrangePredicate orangePredicate;

        @Autowired
        private AppleProcessor appleProcessor;

        @Autowired
        private ApplePredicate applePredicate;

        @Autowired
        private IsNotAFruitProcessor isNotAFruitProcessor;

        @Override
        public void configure() {
            from("kafka:test?brokers=localhost:9092")
                    //.log("Message received from Kafka : ${body}");
                    .choice()
                        .when(orangePredicate)
                            .process(orangeProcessor)
                        .when(applePredicate)
                            .process(appleProcessor)
                        .otherwise()
                            .process(isNotAFruitProcessor)
                    .end();
        }
    }

}
