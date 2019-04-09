package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookConnector;
import com.gg.proj.consumer.connectors.LoanConnector;
import com.gg.proj.consumer.connectors.ProfileConnector;
import com.gg.proj.consumer.connectors.UserConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
@EnableConfigurationProperties
@ComponentScan("com.gg.proj.consumer")
public class ConsumerConfiguration {

    private ConsumerProperties consumerProperties;

    @Autowired
    public ConsumerConfiguration(ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
    }

    @Bean
    public Jaxb2Marshaller bookMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.gg.proj.consumer.wsdl.books");
        return marshaller;
    }

    @Bean
    public BookConnector bookConnector(@Autowired Jaxb2Marshaller bookMarshaller) {
        BookConnector client = new BookConnector(consumerProperties);
        client.setDefaultUri(consumerProperties.getUri());
        client.setMarshaller(bookMarshaller);
        client.setUnmarshaller(bookMarshaller);
        return client;
    }

    @Bean
    public Jaxb2Marshaller userMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.gg.proj.consumer.wsdl.users");
        return marshaller;
    }

    @Bean
    public UserConnector userConnector(@Autowired Jaxb2Marshaller userMarshaller) {
        UserConnector client = new UserConnector(consumerProperties);
        client.setDefaultUri(consumerProperties.getUri());
        client.setMarshaller(userMarshaller);
        client.setUnmarshaller(userMarshaller);
        return client;
    }

    @Bean
    public Jaxb2Marshaller profileMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.gg.proj.consumer.wsdl.profiles");
        return marshaller;
    }

    @Bean
    public ProfileConnector profileConnector(@Autowired Jaxb2Marshaller profileMarshaller) {
        ProfileConnector client = new ProfileConnector(consumerProperties);
        client.setDefaultUri(consumerProperties.getUri());
        client.setMarshaller(profileMarshaller);
        client.setUnmarshaller(profileMarshaller);
        return client;
    }

    @Bean
    public Jaxb2Marshaller loanMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.gg.proj.consumer.wsdl.loans");
        return marshaller;
    }

    @Bean
    public LoanConnector loanConnector(@Autowired Jaxb2Marshaller loanMarshaller) {
        LoanConnector client = new LoanConnector(consumerProperties);
        client.setDefaultUri(consumerProperties.getUri());
        client.setMarshaller(loanMarshaller);
        client.setUnmarshaller(loanMarshaller);
        return client;
    }
}
