package com.example.MoneyLion.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client adamMb = new Client(
                    "Mobile Banking",
                    "adam99@gmail.com",
                    false
            );

            Client sharonFt = new Client(
                    "Financial Tracking",
                    "sharon99@gmail.com",
                    true
            );

            Client hansSn = new Client(
                    "Safety Net",
                    "hans19@gmail.com",
                    false
            );

            Client bruceSn = new Client(
                    "Safety Net",
                    "bruce07@gmail.com",
                    true
            );

            Client hansFt = new Client(
                    "Financial Tracking",
                    "hans19@gmail.com",
                    false
            );

            repository.saveAll(
                    List.of(adamMb, sharonFt, hansSn, bruceSn, hansFt)
            );
        };
    }
}
