package com.example.tour.Configs;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(@NonNull CorsRegistry corsRegistry){
        corsRegistry
                .addMapping("/api/**")
                .allowedOrigins("https://crazy-zam.github.io/neo-tour","https://crazy-zam.github.io")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
