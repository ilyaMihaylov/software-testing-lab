package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://www.expedia.com/";
    private final int WAIT_TIMEOUT = 30;

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsTabButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement flightOriginInput;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement flightDestinationInput;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departingDateInput;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDateInput;

    @FindBy(xpath = "//button[@class='btn-primary btn-action gcw-submit']")
    private WebElement submitButton;

    @FindBy(id = "flight-add-hotel-checkbox-hp-flight")
    private WebElement addHotelCheckbox;

    @FindBy(id = "flight-hotel-checkin-hp-flight")
    private WebElement hotelCheckInDateInput;

    @FindBy(id = "flight-hotel-checkout-hp-flight")
    private WebElement hotelCheckOutDateInput;

    @FindBy(id = "header-language-2058")
    private WebElement changeLanguageToSpanishButton;

    @FindBy(id = "header-language-2052")
    private WebElement changeLanguageToChineseButton;

    @FindBy(id = "header-language-1033")
    private WebElement changeLanguageToEnglishButton;

    @FindBy(id="pi-interstitial")
    private WebElement searchProgressBar;

    @FindBy(xpath = "//span[@data-test-id='listing-price-dollars'][1]")
    private WebElement firstTicketPrice;

    @FindBy(xpath = "//span[@data-test-id='airline-name'][1]")
    private WebElement firstTicketAirline;

    @FindBy(xpath = "//h4[@class='hotelName fakeLink'][1]")
    private WebElement firstHotelName;

    @FindBy(xpath = "//div[@data-test-id='flight-info'][1]")
    private WebElement firstTicketAirports;

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    @FindBy(xpath = "//*[@id='sortDropdown']/option[2]")
    private WebElement sortDropdownByHighestPriceOption;

    @FindBy(xpath = "//*[@id='airlines']/div/label[1]/div/div[1]/span[2]")
    private WebElement firstAirlinesFilterLabel;

    @FindBy(xpath = "//*[@id='airlines']/div/label[1]/div/div[1]")
    private WebElement firstAirlinesFilterContainer;

    @FindBy(xpath = "//div[@class='multiLineDisplay'][1]")
    private WebElement firstAutocompleteVariant;

    @FindBy(xpath = "//a[@href='#flight-departing-hp-flight']")
    private WebElement departingDateInputError;

    @FindBy(xpath = "//a[@href='#flight-returning-hp-flight']")
    private WebElement returningDateInputError;

    @FindBy(xpath = "//a[@href='#flight-origin-hp-flight']")
    private WebElement flightOriginInputError;

    @FindBy(xpath = "//a[@href='#flight-destination-hp-flight']")
    private WebElement flightDestinationInputError;

    @FindBy(xpath = "//button[@class='btn-secondary btn-action t-select-btn'][1]")
    private WebElement firstTicketSelectButton;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement modalNoThanksButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToFlightsTab() {
        flightsTabButton.click();
    }

    public void changeLanguage(String language) {
        if (language.equals("English")) {
            changeLanguageToEnglishButton.click();
        } else if (language.equals("Spanish")) {
            changeLanguageToSpanishButton.click();
        } else if (language.equals("Chinese")) {
            changeLanguageToChineseButton.click();
        } else {
            throw new IllegalArgumentException("Invalid language: " + language);
        }
    }

    public void fillOriginCityAirportInput(String originCity) {
        flightOriginInput.click();
        flightOriginInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), originCity, Keys.ESCAPE);
    }

    public void fillDestinationCityAirportInput(String destinationCity) {
        flightDestinationInput.click();
        flightDestinationInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), destinationCity, Keys.ESCAPE);
    }

    public void fillFlightDepartingDate(String departingDate) {
        departingDateInput.click();
        departingDateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), departingDate, Keys.ESCAPE);
    }

    public void fillFlightReturningDate(String returningDate) {
        returningDateInput.click();
        returningDateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), returningDate, Keys.ESCAPE);
    }

    public void clickAddHotelCheckbox() {
        addHotelCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickSortDropdown() {
        sortDropdown.click();
    }

    public void clickOptionSortByHighest() {
        sortDropdownByHighestPriceOption.click();
    }

    public void clickFirstAirlinesFilterContainer() {
        firstAirlinesFilterContainer.click();
    }

    public void clickFirstTicketSelectButton() {
        firstTicketSelectButton.click();
    }

    public void clickModalNoThanksButton() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(modalNoThanksButton));
        modalNoThanksButton.click();
    }

    public void waitUntilSearchProgressBarIsInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOf(searchProgressBar));
    }

    public String getHotelCheckInDate() {
        return hotelCheckInDateInput.getAttribute("value");
    }

    public String getHotelCheckOutDate() {
        return hotelCheckOutDateInput.getAttribute("value");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getFirstTicketPrice() {
        return firstTicketPrice.getAttribute("textContent").substring(1);
    }

    public String getFirstAirlinesFilterLabel() {
        return firstAirlinesFilterLabel.getText();
    }

    public String getFirstTicketAirline() {
        return firstTicketAirline.getText();
    }

    public String getFirstAutocompleteText() {
        return firstAutocompleteVariant.getText();
    }

    public String getDepartingDateInputErrorMessage() {
        return departingDateInputError.getText();
    }

    public String getReturningDateInputErrorMessage() {
        return returningDateInputError.getText();
    }

    public String getFlightOriginInputErrorMessage() {
        return flightOriginInputError.getText();
    }

    public String getFlightDestinationInputErrorMessage() {
        return flightDestinationInputError.getText();
    }

    public String getFirstHotelName() {
        return firstHotelName.getText();
    }

    public String getFirstTicketAirports() {
        return firstTicketAirports.getText();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
