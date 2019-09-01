package com.gabryelrock.poc.kafka_camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class IsNotAFruitProcessor implements Processor {

    private static final Logger logger = Logger.getLogger(OrangeProcessor.class.getName());

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("the payload does not contains a fruit");
    }

}
