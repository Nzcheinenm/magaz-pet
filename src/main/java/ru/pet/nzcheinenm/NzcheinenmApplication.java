package ru.pet.nzcheinenm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"ru.pet.nzcheinenm"})
@OpenAPIDefinition
@SpringBootApplication
public class NzcheinenmApplication {
    public static void main(String[] args) {
        SpringApplication.run(NzcheinenmApplication.class, args);
    }
}
