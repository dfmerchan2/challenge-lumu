package co.com.wordcounter.tasks;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static co.com.wordcounter.utilities.Operations.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@Slf4j
@AllArgsConstructor
public class WordAnalysis implements Task {

    private final String word;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Long> listWord = getKeywordDensity(getListWords(word));
        log.info(String.format("Words: %s", getCountWords(word)));
        log.info(String.format("Characters: %s", getCountCharacters(word)));
        listWord.forEach(
                (key, value) ->
                        log.info(String.format("%s: %s", key, value))
        );
    }

    public static Performable toEvaluate(String word) {
        return instrumented(WordAnalysis.class, word);
    }
}
