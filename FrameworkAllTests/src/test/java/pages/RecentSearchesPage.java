package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentSearchesPage extends AbstractPage {
    private final String BASE_URL = "https://www.expedia.com/scratchpad?recentSearches=true";

    @FindBy(xpath = "//h3[@class='group-title truncate']")
    private WebElement lastSearchTitle;

    public RecentSearchesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getLastSearchTitle() {
        return lastSearchTitle.getText();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
