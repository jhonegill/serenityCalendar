package org.example.serenityCalendar.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.serenityCalendar.userinterfaces.CalendarPage;
import org.example.serenityCalendar.utils.WebVisualHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SelectDynamicDate implements Task {

    private final String date;

    public SelectDynamicDate(String date) {
        this.date = date;
    }

    public static SelectDynamicDate withValue(String date) {
        return Tasks.instrumented(SelectDynamicDate.class, date);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(CalendarPage.DEMO_IFRAME.resolveFor(actor));
        WebElement input = CalendarPage.DATE_INPUT.resolveFor(actor);
        WebVisualHelper.highlightElement(actor, input);
        Serenity.takeScreenshot();
        input.click();
        WebVisualHelper.removeHighlight(actor, input);
        LocalDate target = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH));
        LocalDate today = LocalDate.now();
        boolean isFuture = target.isAfter(today);
        String targetMonth = target.getMonth()
                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);
        String targetYear = String.valueOf(target.getYear());
        while (true) {
            WebElement title = CalendarPage.CALENDAR_TITLE.resolveFor(actor);
            String currentMonthYear = title.getText();
            if (currentMonthYear.contains(targetMonth) && currentMonthYear.contains(targetYear)) {
                break;
            }
            WebElement navButton = isFuture
                    ? CalendarPage.NEXT_MONTH_BUTTON.resolveFor(actor)
                    : CalendarPage.PREVIOUS_MONTH_BUTTON.resolveFor(actor);
            WebVisualHelper.highlightElement(actor, navButton);
            Serenity.takeScreenshot();
            navButton.click();
            WebVisualHelper.removeHighlight(actor, navButton);
        }
        WebElement dayElement = CalendarPage.DAY(target.getDayOfMonth()).resolveFor(actor);
        WebVisualHelper.highlightElement(actor, dayElement);
        Serenity.takeScreenshot();
        dayElement.click();
        WebVisualHelper.removeHighlight(actor, dayElement);
        driver.switchTo().defaultContent();
    }
}
