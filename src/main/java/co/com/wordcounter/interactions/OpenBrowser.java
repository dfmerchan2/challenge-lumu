package co.com.wordcounter.interactions;

import co.com.wordcounter.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenBrowser implements Interaction {

    private HomePage homePage;

    @Override
    @Step("{0} open the browser with the url #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(homePage)
        );
    }

    public static Performable wordCounter() {
        return instrumented(OpenBrowser.class);
    }
}
