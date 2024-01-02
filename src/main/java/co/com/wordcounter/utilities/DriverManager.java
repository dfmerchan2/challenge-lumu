package co.com.wordcounter.utilities;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverManager {

    public static WebDriver getWebDriver(String browser) {
        WebDriver webDriver;

        switch (browser) {
            case "chrome" -> webDriver = new ChromeDriver();
            case "firefox" -> webDriver = new FirefoxDriver();
            case "edge" -> webDriver = new EdgeDriver();
            default -> {
                log.error("The browser is invalid");
                return null;
            }
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static String getBrowser() {
        String[] drivers = {"chrome", "firefox", "edge"};
        int value = Faker.instance().random().nextInt(drivers.length);
        return drivers[value];
    }
}
