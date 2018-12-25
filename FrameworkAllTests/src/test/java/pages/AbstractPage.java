package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    WebDriver driver;

    public abstract void openPage();

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
