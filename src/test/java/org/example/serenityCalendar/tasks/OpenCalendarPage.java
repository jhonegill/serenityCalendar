package org.example.serenityCalendar.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class OpenCalendarPage {
    public static Performable url() {
        return Open.url("https://jqueryui.com/datepicker/");
    }
}
