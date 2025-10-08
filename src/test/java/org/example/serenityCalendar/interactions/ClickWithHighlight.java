package org.example.serenityCalendar.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.example.serenityCalendar.utils.WebVisualHelper;


public class ClickWithHighlight implements Interaction {

    private final Target target;

    public ClickWithHighlight(Target target) {
        this.target = target;
    }

    public static ClickWithHighlight on(Target target) {
        return Tasks.instrumented(ClickWithHighlight.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        var element = target.resolveFor(actor);
        WebVisualHelper.highlightElement(actor, element);
        element.click();
        WebVisualHelper.removeHighlight(actor, element);
    }
}