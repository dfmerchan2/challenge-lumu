package co.com.wordcounter.stepdefinitions;

import co.com.wordcounter.interactions.OpenBrowser;
import co.com.wordcounter.tasks.EnterTheSentence;
import co.com.wordcounter.tasks.WordAnalysis;
import co.com.wordcounter.utilities.Operations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static co.com.wordcounter.userinterfaces.HomePage.*;
import static co.com.wordcounter.utilities.ActorNotepad.WORD_VALUE;
import static co.com.wordcounter.utilities.Operations.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class WordCounterStepDefinition {

    @Given("that {string} entered the WordCounter page")
    public void enteredTheWordCounterPage(String actor) {
        theActorCalled(actor).attemptsTo(
                OpenBrowser.wordCounter()
        );
    }

    @When("enter the phrase {string}")
    public void enterThePhrase(String word) {
        theActorInTheSpotlight().attemptsTo(
                EnterTheSentence.toEvaluate(word)
        );
    }

    @And("it generated an analysis of the entered word")
    public void itGeneratedAnAnalysisOfTheEnteredWord() {
        String word = theActorInTheSpotlight().recall(WORD_VALUE.getKey());

        theActorInTheSpotlight().attemptsTo(
                WordAnalysis.toEvaluate(word)
        );
    }

    @Then("should can validate the Keyword Density")
    public void shouldCanValidateTheKeywordDensity() {
        String word = theActorInTheSpotlight().recall(WORD_VALUE.getKey());
        Map<String, Long> listWord = getKeywordDensity(removeExcludedWords(word));

        listWord.forEach(
                (key, value) -> theActorInTheSpotlight().should(
                        seeThat(String.format("Validates that the density of the keyword '%s' is '%s'", key, value),
                                actor -> getValue(LBL_KEYWORD_DENSITY.of(key), actor),
                                equalTo(String.valueOf(value)))
                )
        );
    }

    @And("should look at the detail of the word")
    public void shouldLookAtTheDetailOfTheWord() {
        String word = theActorInTheSpotlight().recall(WORD_VALUE.getKey());

        theActorInTheSpotlight().should(
                seeThat("Validate the number of words",
                        actor -> LBL_WORDS.resolveFor(actor).getText(),
                        equalTo(Operations.getCountWords(word))),
                seeThat("Validate the number of characters",
                        actor -> LBL_CHARACTERS.resolveFor(actor).getText(),
                        equalTo(Operations.getCountCharacters(word)))
        );
    }

}
