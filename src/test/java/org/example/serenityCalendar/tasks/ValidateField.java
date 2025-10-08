package org.example.serenityCalendar.tasks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.serenityCalendar.interactions.EnterWithHighlight;
import org.example.serenityCalendar.userinterfaces.CalendarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class ValidateField {

    private static final String TEST_DATE = "10/10/2025";

    public static Performable tryManualInput() {
        return Task.where("{0} tries to manually input a date", actor -> {

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            driver.switchTo().frame(CalendarPage.DEMO_IFRAME.resolveFor(actor));
            EnterWithHighlight.theValue(TEST_DATE).into(CalendarPage.DATE_INPUT).performAs(actor);
            Serenity.takeScreenshot();
            driver.switchTo().defaultContent();
        });
    }

    public static Question<Boolean> isEditable() {
        return actor -> {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            driver.switchTo().frame(CalendarPage.DEMO_IFRAME.resolveFor(actor));
            WebElement input = CalendarPage.DATE_INPUT.resolveFor(actor);
            boolean editable = input.getAttribute("readonly") == null;
            driver.switchTo().defaultContent();
            return editable;
        };
    }
}