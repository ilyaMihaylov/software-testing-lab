package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://www.expedia.com/";

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsTabButton;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departingDateInput;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDateInput;

    @FindBy(id = "flight-add-hotel-checkbox-hp-flight")
    private WebElement addHotelCheckbox;

    @FindBy(id = "flight-hotel-checkin-hp-flight")
    private WebElement hotelCheckInDateInput;

    @FindBy(id = "flight-hotel-checkout-hp-flight")
    private WebElement hotelCheckOutDateInput;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToFlightsTab() {
        flightsTabButton.click();
    }

    public void fillFlightDatesInputs(String departingDate, String returningDate) {
        departingDateInput.sendKeys(departingDate);
        returningDateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), returningDate);
    }

    public void clickAddHotelCheckbox() {
        addHotelCheckbox.click();
    }

    public String getHotelCheckInDate () {
        return hotelCheckInDateInput.getAttribute("value");
    }

    public String getHotelCheckOutDate () {
        return hotelCheckOutDateInput.getAttribute("value");
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
