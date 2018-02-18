package ru.maximov.springtestingpresentation.beansonconditions;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IronMan implements Character {

    TonyStark tonyStark;

    @Override
    public void speak() {
        tonyStark.speak();
        System.out.println("И да, я - Железный Человек!");
    }

}
