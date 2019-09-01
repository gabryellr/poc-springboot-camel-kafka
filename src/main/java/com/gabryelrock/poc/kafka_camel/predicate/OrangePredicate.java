package com.gabryelrock.poc.kafka_camel.predicate;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;

@Component
public class OrangePredicate implements Predicate {

    @Override
    public boolean matches(Exchange exchange) {
        return exchange.getIn().getBody(String.class).toLowerCase().contains("orange");
    }

}
