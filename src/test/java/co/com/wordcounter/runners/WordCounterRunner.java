package co.com.wordcounter.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/wordcounter.feature",
        plugin = {"pretty", "summary"},
        glue = "co.com.wordcounter.stepdefinitions",
        snippets = CAMELCASE
)

public class WordCounterRunner {
}
