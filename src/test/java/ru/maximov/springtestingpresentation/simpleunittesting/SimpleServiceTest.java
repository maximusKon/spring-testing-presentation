package ru.maximov.springtestingpresentation.simpleunittesting;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleServiceTest {

    @Mock
    private ExternalSystemInterface externalSystem;

    private SimpleService simpleService;

    @Before
    public void before(){
        simpleService = new SimpleService(externalSystem);
    }

    @Test
    public void sendSomeData() {
        val testData = new SomeData(42, "The Answer");

        simpleService.sendSomeData(testData);

        val expectedMessage = "First Line with '42' value\nSecond Line with 'The Answer' value";
        verify(externalSystem).sendMessage(expectedMessage);
    }
}