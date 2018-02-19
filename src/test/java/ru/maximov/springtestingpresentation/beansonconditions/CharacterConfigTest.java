package ru.maximov.springtestingpresentation.beansonconditions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


public class CharacterConfigTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {CharacterConfig.class})
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
    @ContextConfiguration(classes = {CharacterConfig.class})
    public static class CharacterConfigTestDefaultProfile {

        @Autowired
        private Character character;

        @Test
        public void test() {

            assertTrue(character instanceof IronMan);

        }

    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {CharacterConfig.class})
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
    @ContextConfiguration(classes = {CharacterConfig.class})
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