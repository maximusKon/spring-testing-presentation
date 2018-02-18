package ru.maximov.springtestingpresentation.configproperties;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SchoolClubPropertiesConfig.class})
@SpringBootApplication
@ActiveProfiles("testProperties")
public class SchoolClubPropertiesConfigTest {

    @Autowired
    private SchoolClubProperties schoolClubProperties;

    @Test
    public void schoolClubProperties_clubName(){
        val clubName = schoolClubProperties.getClubName();

        assertThat(clubName, is("Клуб любителей литературы"));
    }

    @Test
    public void schoolClubProperties_members(){
        val members = Arrays.asList(schoolClubProperties.getMembers());

        assertThat(members.size(), is(3));
        assertThat(members,
                contains(
                        new ClubMember("Моника", 17),
                        new ClubMember("Саёри", 16),
                        new ClubMember("Юра", 18)
                )
        );
    }

}