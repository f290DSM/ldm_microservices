package dev.sdras.microservices.clientms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
