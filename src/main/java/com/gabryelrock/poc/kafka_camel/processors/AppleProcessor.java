package com.gabryelrock.poc.kafka_camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AppleProcessor implements Processor {

    private static final Logger logger = Logger.getLogger(OrangeProcessor.class.getName());

    @Override
    public void process(Exchange exchange) {
        String payload = exchange.getIn().getBody(String.class);
        logger.info("the payload contains apple word: " + payload);
    }

}