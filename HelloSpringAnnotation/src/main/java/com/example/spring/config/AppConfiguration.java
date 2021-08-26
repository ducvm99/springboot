package com.example.spring.config;

import com.example.spring.lang.Language;
import com.example.spring.lang.impl.Vietnamese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.spring.bean"})
public class AppConfiguration {

    @Bean(name = "language")
    public Language getLanguage() {
        return new Vietnamese();
    }
}
