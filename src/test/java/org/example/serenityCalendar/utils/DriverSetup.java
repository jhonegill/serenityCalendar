package org.example.serenityCalendar.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;

public class DriverSetup {

    public static void setupDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        System.out.println(">>> Browser: " + browser);
        System.out.println(">>> Headless mode: " + headless);

        switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver().setup();
            case "firefox" -> WebDriverManager.firefoxdriver().setup();
            case "edge" -> WebDriverManager.edgedriver().setup();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        Serenity.setSessionVariable("browser").to(browser);
        Serenity.setSessionVariable("headless").to(headless);
    }
}
