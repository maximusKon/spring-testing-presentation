package ru.maximov.springtestingpresentation.controllers;

public class NoSuchObjectException extends Exception {

    public NoSuchObjectException(String message) {
        super(message);
    }
}
