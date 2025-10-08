package org.example.serenityCalendar.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.serenityCalendar.questions.TheSelectedDate;
import org.example.serenityCalendar.tasks.OpenCalendarPage;
import org.example.serenityCalendar.tasks.SelectDate;
import org.example.serenityCalendar.tasks.SelectDynamicDate;
import org.example.serenityCalendar.tasks.ValidateField;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
public class ScheduleStepDefinitions {


    @Given("the user opens the Calendar page")
    public void openCalendarPage() {
        OnStage.theActorCalled("User").wasAbleTo(OpenCalendarPage.url());
    }

    @When("the user selects day {int} of the current month")
    public void selectDayCurrentMonth(int day) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectDate.currentMonth(day));
    }

    @When("the user selects day {int} of the next month")
    public void selectDayNextMonth(int day) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectDate.nextMonth(day));
    }

    @When("the user tries to type a date manually")
    public void triesToTypeDate() {
        OnStage.theActorInTheSpotlight().attemptsTo(ValidateField.tryManualInput());
    }

    @Then("the selected date should appear in the input field")
    public void validateSelectedDate() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheSelectedDate.value(), not(isEmptyString())));
    }

    @Then("the field should not be editable manually")
    public void validateFieldNotEditable() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ValidateField.isEditable(), equalTo(false)));
    }
    @When("the user selects the date {string}")
    public void userSelectsDate(String date) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectDynamicDate.withValue(date)
        );
    }
}
