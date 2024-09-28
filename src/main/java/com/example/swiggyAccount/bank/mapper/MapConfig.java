package com.example.swiggyAccount.bank.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
