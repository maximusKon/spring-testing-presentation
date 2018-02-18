package ru.maximov.springtestingpresentation.configproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConfigurationProperties("schoolClub")
public @interface SchoolClubConfigurationProperties {
}
