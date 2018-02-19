package ru.maximov.springtestingpresentation.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RockBand {

    long id;

    String name;

    public RockBand(String name) {
        this(0, name);
    }
}
