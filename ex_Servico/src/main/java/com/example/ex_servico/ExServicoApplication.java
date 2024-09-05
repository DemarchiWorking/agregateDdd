package com.example.ex_servico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExServicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExServicoApplication.class, args);
    }

}
