package org.example.serenityCalendar.config;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.serenityCalendar.utils.DriverSetup;

public class SetStage {
    @Before
    public void setUp() {
        DriverSetup.setupDriver();
        OnStage.setTheStage(new OnlineCast());
    }
}
