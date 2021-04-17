package com.jeffsimonitto.spring.springbootplayground.config;

import com.jeffsimonitto.spring.springbootplayground.formatters.DateFormatter;
import com.jeffsimonitto.spring.springbootplayground.formatters.VarietyFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public VarietyFormatter varietyFormatter() {
        return new VarietyFormatter();
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(varietyFormatter());
        registry.addFormatter(dateFormatter());
    }
}
