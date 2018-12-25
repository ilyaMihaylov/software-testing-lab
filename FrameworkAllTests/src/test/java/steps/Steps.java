package steps;

import driver.DriverSingleton;
import pages.CheckoutPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import pages.RecentSearchesPage;

import java.util.ArrayList;

public class Steps {
    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
    }

    public void openRecentSearchesPage() {
        RecentSearchesPage recentSearchesPage = new RecentSearchesPage(driver);
        recentSearchesPage.openPage();
    }

    public void navigateToFlightsTab() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToFlightsTab();
    }

    public void fillOriginCityAirportInput(String originCity) {
        HomePage homePage = new HomePage(driver);
        homePage.fillOriginCityAirportInput(originCity);
    }

    public void fillAirportInputs(String originCity, String destinationCity) {
        HomePage homePage = new HomePage(driver);
        homePage.fillOriginCityAirportInput(originCity);
        homePage.fillDestinationCityAirportInput(destinationCity);
    }

    public void fillDateInputs(String departureDate, String returningDate) {
        HomePage homePage = new HomePage(driver);
        homePage.fillFlightDepartingDate(departureDate);
        homePage.fillFlightReturningDate(returningDate);
    }

    public void clickAddHotelCheckbox() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAddHotelCheckbox();
    }

    public void clickSubmitButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSubmitButton();
    }

    public void clickFirstTicketSelectButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFirstTicketSelectButton();
    }

    public void clickModalNoThanksButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickModalNoThanksButton();
    }

    public void changeLanguage(String language) {
        HomePage homePage = new HomePage(driver);
        homePage.changeLanguage(language);
    }

    public void sortByHighestPrice() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSortDropdown();
        homePage.clickOptionSortByHighest();
    }

    public void waitUntilSearchProgressBarIsInvisible() {
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilSearchProgressBarIsInvisible();
    }

    public String clickFirstAirlinesFilterAndGetLabelText() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFirstAirlinesFilterContainer();
        return homePage.getFirstAirlinesFilterLabel();
    }

    public String getPageTitle() {
        HomePage homePage = new HomePage(driver);
        return homePage.getPageTitle();
    }

    public String getHotelCheckInDate() {
        HomePage homePage = new HomePage(driver);
        return homePage.getHotelCheckInDate();
    }

    public String getHotelCheckOutDate() {
        HomePage homePage = new HomePage(driver);
        return homePage.getHotelCheckOutDate();
    }

    public String getLastSearchTitle() {
        RecentSearchesPage recentSearchesPage = new RecentSearchesPage(driver);
        return recentSearchesPage.getLastSearchTitle();
    }

    public String getFirstTicketPrice() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFirstTicketPrice();
    }

    public String getFirstTicketAirline() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFirstTicketAirline();
    }

    public String getFirstAutocompleteText() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFirstAutocompleteText();
    }

    public String getDepartingDateInputErrorMessage() {
        HomePage homePage = new HomePage(driver);
        return homePage.getDepartingDateInputErrorMessage();
    }

    public String getReturningDateInputErrorMessage() {
        HomePage homePage = new HomePage(driver);
        return homePage.getReturningDateInputErrorMessage();
    }

    public String getFlightOriginInputErrorMessage() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFlightOriginInputErrorMessage();
    }

    public String getFlightDestinationInputErrorMessage() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFlightDestinationInputErrorMessage();
    }

    public String getFirstHotelName() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFirstHotelName();
    }

    public String getFirstTicketAirports() {
        HomePage homePage = new HomePage(driver);
        return homePage.getFirstTicketAirports();
    }

    public String getFirstCheckoutTicketAirline() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getFirstCheckoutTicketAirline();
    }

    public String getFirstCheckoutTicketFromAirport() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getFirstCheckoutTicketFromAirport();
    }

    public String getFirstCheckoutTicketToAirport() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getFirstCheckoutTicketToAirport();
    }

    public String getSecondCheckoutTicketAirline() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getSecondCheckoutTicketAirline();
    }

    public String getSecondCheckoutTicketFromAirport() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getSecondCheckoutTicketFromAirport();
    }

    public String getSecondCheckoutTicketToAirport() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage.getSecondCheckoutTicketToAirport();
    }

    public void switchTabs(int tabNumber) {
        ArrayList<String> tabsList = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(tabNumber));
    }


}
