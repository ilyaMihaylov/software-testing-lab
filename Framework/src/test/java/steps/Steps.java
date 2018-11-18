package steps;

import driver.DriverSingleton;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void fillDatesAndCheckAddHotel(String departureDate, String returningDate) {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.navigateToFlightsTab();
        homePage.fillFlightDatesInputs(departureDate, returningDate);
        homePage.clickAddHotelCheckbox();
    }

    public String getHotelCheckInDate() {
        HomePage homePage = new HomePage(driver);
        return homePage.getHotelCheckInDate();
    }

    public String getHotelCheckOutDate() {
        HomePage homePage = new HomePage(driver);
        return homePage.getHotelCheckOutDate();
    }
}
