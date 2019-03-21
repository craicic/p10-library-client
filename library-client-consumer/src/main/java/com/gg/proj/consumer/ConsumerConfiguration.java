package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookConnector;
import com.gg.proj.consumer.connectors.LoanConnector;
import com.gg.proj.consumer.connectors.ProfileConnector;
import com.gg.proj.consumer.connectors.UserConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConsumerConfiguration {

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
        BookConnector client = new BookConnector();
        client.setDefaultUri("http://localhost:8080/ws");
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
        UserConnector client = new UserConnector();
        client.setDefaultUri("http://localhost:8080/ws");
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
        ProfileConnector client = new ProfileConnector();
        client.setDefaultUri("http://localhost:8080/ws");
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
        LoanConnector client = new LoanConnector();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(loanMarshaller);
        client.setUnmarshaller(loanMarshaller);
        return client;
    }
}
