package org.example.serenityCalendar.config;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"classpath:features"},
    glue = {"org.example"},
    tags = "@Calendar",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
@SuppressWarnings("java:S2187")
public class CucumberTest {

}
