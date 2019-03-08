package com.gg.proj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.gg.proj.consumer",
        "com.gg.proj.consumer.connectors",
        "com.gg.proj.technical",
        "com.gg.proj.business",
        "com.gg.proj.business.mapper",
        "com.gg.proj.webapp",
        "com.gg.proj.authentication"})
public class LibraryClientWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryClientWebappApplication.class, args);
    }

}

