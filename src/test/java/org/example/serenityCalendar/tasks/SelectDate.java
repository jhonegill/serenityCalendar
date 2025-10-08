package org.example.serenityCalendar.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.serenityCalendar.interactions.ClickWithHighlight;
import org.example.serenityCalendar.userinterfaces.CalendarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDate implements Task {

    private final int day;
    private final boolean nextMonth;

    public SelectDate(int day, boolean nextMonth) {
        this.day = day;
        this.nextMonth = nextMonth;
    }

    public static SelectDate currentMonth(int day) {
        return instrumented(SelectDate.class, day, false);
    }

    public static SelectDate nextMonth(int day) {
        return instrumented(SelectDate.class, day, true);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement iframe = CalendarPage.DEMO_IFRAME.resolveFor(actor);
        driver.switchTo().frame(iframe);

        actor.attemptsTo(ClickWithHighlight.on(CalendarPage.DATE_INPUT));

        if (nextMonth) {
            actor.attemptsTo(ClickWithHighlight.on(CalendarPage.NEXT_MONTH_BUTTON));
        }

        actor.attemptsTo(ClickWithHighlight.on(CalendarPage.DAY(day)));
        Serenity.takeScreenshot();
        driver.switchTo().defaultContent();
    }
}