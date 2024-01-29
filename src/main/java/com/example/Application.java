package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        Logger log = LoggerFactory.getLogger(Application.class);
        log.info("Java app started");

        // Ejemplo de uso de la calculadora
        Calculator calculator = new Calculator();
        log.info("Add result: " + calculator.add(2, 3));
        log.info("Subtract result: " + calculator.subtract(5, 3));
        log.info("Multiply result: " + calculator.multiply(3, 5));
        log.info("Divide result: " + calculator.divide(6, 3));
        try {
            log.info("Divide by zero result: " + calculator.divide(6, 0));
        } catch (IllegalArgumentException e) {
            log.error("Error: " + e.getMessage());
        }
    }

    public String getStatus() {
        return "OK";
    }
}
