package com.example.ex_microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExMicroservicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExMicroservicoApplication.class, args);
    }

}
