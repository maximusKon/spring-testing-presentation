package ru.maximov.springtestingpresentation.configproperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolClubPropertiesConfig {

    @Bean
    @SchoolClubConfigurationProperties
    public SchoolClubProperties schoolClubProperties(){
        return new SchoolClubProperties();
    }

}
