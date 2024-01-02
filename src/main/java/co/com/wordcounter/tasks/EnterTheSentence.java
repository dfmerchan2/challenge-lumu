package co.com.wordcounter.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.wordcounter.userinterfaces.HomePage.TXT_RESIZABLE_TEXTAREA;
import static co.com.wordcounter.utilities.ActorNotepad.WORD_VALUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class EnterTheSentence implements Task {

    private final String word;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(TXT_RESIZABLE_TEXTAREA),
                Enter.theValue(word).into(TXT_RESIZABLE_TEXTAREA)
        );
        actor.remember(WORD_VALUE.getKey(), word);
    }

    public static Performable toEvaluate(String word) {
        return instrumented(EnterTheSentence.class, word);
    }
}
