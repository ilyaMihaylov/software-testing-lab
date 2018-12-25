package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends AbstractPage {
    private final String BASE_URL = "https://www.expedia.com/Flights-Search?flight-type=on&starDate=12%2F31%2F2018" +
            "&endDate=01%2F07%2F2019&mode=search&trip=roundtrip" +
            "&leg1=from%3AMoscow%2C+Russia+%28MOW%29%2Cto%3ATokyo%2C+Japan+%28TYO%29%2Cdeparture%3A12%2F31%2F2018TANYT" +
            "&leg2=from%3ATokyo%2C+Japan+%28TYO%29%2Cto%3AMoscow%2C+Russia+%28MOW%29%2Cdeparture%3A01%2F07%2F2019TANYT" +
            "&passengers=children%3A0%2Cadults%3A1%2Cseniors%3A0%2Cinfantinlap%3AY";
    //Without parameters page doesn't exist ¯\_(ツ)_/¯

    @FindBy(xpath = "//div[@class='search-saved-cta']/span")
    private WebElement lastSearchTitle;

    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
