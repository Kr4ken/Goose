package com.kr4ken.goose.setting;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
@Data
public class GooseSetting {
    @Value("${goose.file.mainDirectory}")
    private String mainDirectory;
    @Value("${goose.file.dbDirectory}")
    private String dbDirectory;
    @Value("${goose.file.mediaDirectory}")
    private String mediaDirectory;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
