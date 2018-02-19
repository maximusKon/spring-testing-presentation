package ru.maximov.springtestingpresentation.simpleunittesting;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SimpleService {

    ExternalSystemInterface externalSystem;

    @Autowired
    public SimpleService(ExternalSystemInterface externalSystem) {
        this.externalSystem = externalSystem;
    }

    public void sendSomeData(SomeData somedata){

        val message = formMessage(somedata);

        externalSystem.sendMessage(message);

    }

    private String formMessage(SomeData somedata) {
        return String.format("<intField>%s</intField>\n", somedata.getSomeIntField()) +
                String.format("<stringField>%s</stringField>", somedata.getSomeStringField());
    }
}
