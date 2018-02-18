package ru.maximov.springtestingpresentation.configproperties;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class SchoolClubProperties {

    private String clubName;

    private ClubMember[] members;

}
