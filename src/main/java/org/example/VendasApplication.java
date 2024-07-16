package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.repository",
                               "org.example.service"})
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String ApplicationName;

    @Autowired
    private Animal animal;

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            this.animal.fazerBarulho();
        };
    }


    @GetMapping("/hello")
    public String helloWorld(){
        return ApplicationName ;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
