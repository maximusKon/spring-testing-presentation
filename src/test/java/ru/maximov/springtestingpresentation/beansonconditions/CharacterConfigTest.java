package ru.maximov.springtestingpresentation.beansonconditions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.maximov.springtestingpresentation.configproperties.SchoolClubPropertiesConfig;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.*;


public class CharacterConfigTest {

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = {CharacterConfig.class})
    @SpringBootApplication
    @ActiveProfiles("disableIronMan")
    public static class CharacterConfigTestDisableIronManProfile {

        @Autowired
        private Character character;

        @Test
        public void test() {

            assertTrue(character instanceof TonyStark);

        }

    }

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = {CharacterConfig.class})
    @SpringBootApplication
    public static class CharacterConfigTestDefaultProfile {

        @Autowired
        private Character character;

        @Test
        public void test() {

            assertTrue(character instanceof IronMan);

        }

    }

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = {CharacterConfig.class})
    @SpringBootApplication
    @ActiveProfiles("mockCharacter")
    public static class CharacterConfigTestMockCharacterProfile {

        @Autowired
        private Character character;

        @Test
        public void test() {

            assertTrue(character instanceof CharacterConfig.MockCharacter);

        }

    }

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = {CharacterConfig.class})
    @SpringBootApplication
    @ActiveProfiles(value = {"disableIronMan", "mockCharacter"})
    public static class CharacterConfigTestMockDisableIronManAndCharacterProfile {

        @Autowired
        private Character character;

        @Test
        public void test() {

            assertTrue(character instanceof CharacterConfig.MockCharacter);

        }

    }


}