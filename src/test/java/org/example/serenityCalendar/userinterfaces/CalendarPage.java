package org.example.serenityCalendar.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalendarPage {
    public static final Target DEMO_IFRAME = Target
            .the("demo iframe containing the calendar")
            .located(By.cssSelector("iframe.demo-frame"));

    public static final Target DATE_INPUT = Target
            .the("date input field")
            .located(By.id("datepicker"));

    public static final Target NEXT_MONTH_BUTTON = Target
            .the("next month button")
            .located(By.cssSelector(".ui-datepicker-next"));

    public static final Target PREVIOUS_MONTH_BUTTON = Target
            .the("previous month button")
            .located(By.cssSelector(".ui-datepicker-prev"));

    public static Target DAY(int day) {
        return Target.the("day " + day + " in the calendar")
                .locatedBy("//a[text()='{0}']").of(String.valueOf(day));
    }

    public static final Target CALENDAR_TITLE = Target
            .the("calendar title (month and year)")
            .located(By.cssSelector(".ui-datepicker-title"));
}
