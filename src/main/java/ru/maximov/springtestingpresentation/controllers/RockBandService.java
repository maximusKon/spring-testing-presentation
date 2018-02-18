package ru.maximov.springtestingpresentation.controllers;

public interface RockBandService {

    RockBand getById(long id) throws NoSuchObjectException;

    void add(RockBand rockBand);

}
