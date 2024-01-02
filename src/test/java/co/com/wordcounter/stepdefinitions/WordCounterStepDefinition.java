package co.com.wordcounter.stepdefinitions;

import co.com.wordcounter.interactions.OpenBrowser;
import co.com.wordcounter.tasks.EnterTheSentence;
import co.com.wordcounter.tasks.ValidateKeywordDensity;
import co.com.wordcounter.utilities.Operations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static co.com.wordcounter.userinterfaces.HomePage.LBL_CHARACTERS;
import static co.com.wordcounter.userinterfaces.HomePage.LBL_WORDS;
import static co.com.wordcounter.utilities.ActorNotepad.WORD_VALUE;
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

    @Then("can validate the Keyword Density")
    public void canValidateTheKeywordDensity() {
        String word = theActorInTheSpotlight().recall(WORD_VALUE.getKey());

        theActorInTheSpotlight().attemptsTo(
                ValidateKeywordDensity.ofTheWord(word)
        );
    }

    @And("should look at the detail of the word")
    public void canObserveTheAnalysisObtainedFromThePhrase() {
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
