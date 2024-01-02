package co.com.wordcounter.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Map;

import static co.com.wordcounter.userinterfaces.HomePage.LBL_KEYWORD_DENSITY;
import static co.com.wordcounter.utilities.Operations.getKeywordDensity;
import static co.com.wordcounter.utilities.Operations.getValue;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ValidateKeywordDensity implements Task {

    private final String word;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Long> listWord = getKeywordDensity(word);
        listWord.forEach(
                (k, v) -> actor.attemptsTo(
                        Ensure.that(getValue(LBL_KEYWORD_DENSITY.of(k), actor))
                                .isEqualTo(String.valueOf(v))
                )
        );

    }

    public static Performable ofTheWord(String word) {
        return instrumented(ValidateKeywordDensity.class, word);
    }
}
