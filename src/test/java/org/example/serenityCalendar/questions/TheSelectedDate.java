package org.example.serenityCalendar.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.serenityCalendar.userinterfaces.CalendarPage;

public class TheSelectedDate {
    public static Question<String> value() {
        return actor -> {
            org.openqa.selenium.WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            driver.switchTo().frame(CalendarPage.DEMO_IFRAME.resolveFor(actor));
            String value = CalendarPage.DATE_INPUT.resolveFor(actor).getValue();
            driver.switchTo().defaultContent();
            return value;
        };
    }
}
