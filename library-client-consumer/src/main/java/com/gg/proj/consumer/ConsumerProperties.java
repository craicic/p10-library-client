package com.gg.proj.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("consumer.webservice")
@Component
public class ConsumerProperties {

    /**
     * URI of the SOAP web service that this application uses to reach the endpoint.
     */
    private String uri = "http://localhost:8080/ws";

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}