package co.com.wordcounter.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;
import static org.openqa.selenium.By.xpath;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HomePage extends PageObject {

    public static final Target TXT_RESIZABLE_TEXTAREA = the("Text box textarea")
            .located(xpath("//div[@class='resizable-textarea']//textarea"));

    public static final Target LBL_WORDS = the("Label word count")
            .located(By.id("word_count"));

    public static final Target LBL_CHARACTERS = the("Label character count")
            .located(By.id("character_count"));

    public static final Target LBL_KEYWORD_DENSITY = the("Label Keyword Density")
            .locatedBy("//a[@class='list-group-item' and contains (.,'{0}')]//span[@class='badge']");
}
