package org.example.serenityCalendar.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.example.serenityCalendar.utils.WebVisualHelper;
import org.openqa.selenium.WebElement;

public class EnterWithHighlight implements Interaction {

    private final String text;
    private final Target target;

    public EnterWithHighlight(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static IntoBuilder theValue(String text) {
        return new IntoBuilder(text);
    }

    public static class IntoBuilder {
        private final String text;
        public IntoBuilder(String text) {
            this.text = text;
        }
        public Performable into(Target target) {
            return Tasks.instrumented(EnterWithHighlight.class, text, target);
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        WebVisualHelper.highlightElement(actor, element);
        element.clear();
        element.sendKeys(text);
        WebVisualHelper.removeHighlight(actor, element);
    }
}
