package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractPage {
    private final String BASE_URL = "https://www.expedia.com/Flight-Information?" +
            "continuationId=5c3e2f23-c9ee-4686-ad52-af5d65a7ccea&rfrr=&superlativeMessages[0]=BV,CP&" +
            "superlativeMessages[1]=BV,CP&udpDisplayMode=showhotelbanneronly";

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[1]/div/div/div[3]")
    private WebElement firstCheckoutTicketAirline;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[1]/div/div/div[1]/ol/li[1]/span[2]")
    private WebElement firstCheckoutTicketFromAirport;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[1]/div/div/div[1]/ol/li[2]/span[2]")
    private WebElement firstCheckoutTicketToAirport;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[2]/div/div/div[3]")
    private WebElement secondCheckoutTicketAirline;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[2]/div/div/div[1]/ol/li[1]/span[2]")
    private WebElement secondCheckoutTicketFromAirport;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div[2]/div/div/div[1]/ol/li[2]/span[2]")
    private WebElement secondCheckoutTicketToAirport;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstCheckoutTicketAirline() {
        return firstCheckoutTicketAirline.getText();
    }

    public String getFirstCheckoutTicketFromAirport() {
        return firstCheckoutTicketFromAirport.getText();
    }

    public String getFirstCheckoutTicketToAirport() {
        return firstCheckoutTicketToAirport.getText();
    }

    public String getSecondCheckoutTicketAirline() {
        return secondCheckoutTicketAirline.getText();
    }

    public String getSecondCheckoutTicketFromAirport() {
        return secondCheckoutTicketFromAirport.getText();
    }

    public String getSecondCheckoutTicketToAirport() {
        return secondCheckoutTicketToAirport.getText();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
