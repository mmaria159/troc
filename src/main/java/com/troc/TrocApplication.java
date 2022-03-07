package com.troc;

import org.indigo.dtomapper.providers.MapperFactory;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrocApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrocApplication.class, args);
    }

    @Bean
    public Mapper getMapper() {
        return MapperFactory.getMapper();
    }
}
