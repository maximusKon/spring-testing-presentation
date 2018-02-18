package ru.maximov.springtestingpresentation.beansonconditions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class CharacterConfig {

    @Bean
    @Profile("disableIronMan")
    public Character tonyStark(){
        return new TonyStark();
    }

    @Bean
    @Profile("!disableIronMan")
    public Character ironMan(){
        return new IronMan(new TonyStark());
    }

    @Bean
    @Primary
    @Profile("mockCharacter")
    public Character mockCharacter() {
        return new MockCharacter();
    }

    public static class MockCharacter implements Character {

        @Override
        public void speak() {
            System.out.println("Я - замоканный персонаж");
        }
    }
}
