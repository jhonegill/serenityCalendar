package org.example.serenityCalendar.utils;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.Actor;

public class WebVisualHelper {

    public static void highlightElement(Actor actor, WebElement element) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof JavascriptExecutor js) {
            js.executeScript(
                    "arguments[0].style.border='3px dashed red'; " +
                            "arguments[0].style.backgroundColor='rgba(255,0,0,0.05)';",
                    element
            );
        }
        try {
            Thread.sleep(150);
        } catch (InterruptedException ignored) {}
    }

    public static void removeHighlight(Actor actor, WebElement element) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof JavascriptExecutor js) {
            try {
                js.executeScript(
                        "arguments[0].style.border=''; arguments[0].style.backgroundColor='';",
                        element
                );
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                // Element is no longer in the DOM, ignore
                System.out.println("[INFO] Element became stale after interaction, skipping border removal.");
            }
        }
    }
}
