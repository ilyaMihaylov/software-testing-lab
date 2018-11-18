import org.openqa.selenium.WebDriver;

abstract class AbstractPage {
    WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
