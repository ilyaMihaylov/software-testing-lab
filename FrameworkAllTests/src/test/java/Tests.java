import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Tests {
    private Steps steps;
    private final String DEPARTURE_DATE = "01/07/2019";
    private final String RETURNING_DATE = "01/14/2019";
    private final String ORIGIN_AIRPORT = "Frankfurt, Germany (FRA)";
    private final String DESTINATION_AIRPORT = "Paris, France (PAR)";

    @BeforeEach
    void setUp() {
        steps = new Steps();
        steps.openBrowser();
    }

    @Test
    @DisplayName("Selected language should be applied to page title")
    void testLocalization() {
        String expectedEnglishTitle = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        String expectedSpanishTitle = "Expedia: hoteles, vuelos, renta de autos, cruceros y rentas vacacionales | Expedia";
        //String expectedChineseTitle = "旅行预订网站：特价酒店预订，机票查询，自游行网上优惠 | Expedia.com";

        steps.openHomePage();

        steps.changeLanguage("Spanish");
        Assertions.assertEquals(expectedSpanishTitle, steps.getPageTitle());

        //steps.changeLanguage("Chinese");
        //Assertions.assertEquals(expectedChineseTitle, steps.getPageTitle());

        steps.changeLanguage("English");
        Assertions.assertEquals(expectedEnglishTitle, steps.getPageTitle());
    }

    @Test
    @DisplayName("Previously searched tickets should be saved in recent searches")
    void testRecentSearchesList() {
        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillAirportInputs(ORIGIN_AIRPORT, DESTINATION_AIRPORT);
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickSubmitButton();
        steps.waitUntilSearchProgressBarIsInvisible();
        steps.openRecentSearchesPage();

        Assertions.assertEquals(ORIGIN_AIRPORT + " - " + DESTINATION_AIRPORT, steps.getLastSearchTitle());
    }

    @Test
    @DisplayName("Founded tickets should suit the filters and be sorted by the selected criteria")
    void testSortAndFilters() {
        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillAirportInputs(ORIGIN_AIRPORT, DESTINATION_AIRPORT);
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickSubmitButton();
        steps.waitUntilSearchProgressBarIsInvisible();

        int priceBeforeSorting = Integer.parseInt(steps.getFirstTicketPrice());
        steps.sortByHighestPrice();
        int priceAfterSorting = Integer.parseInt(steps.getFirstTicketPrice());
        Assertions.assertTrue(priceBeforeSorting < priceAfterSorting);

        String filterAirlineName = steps.clickFirstAirlinesFilterAndGetLabelText();
        Assertions.assertTrue(filterAirlineName.contains(steps.getFirstTicketAirline()));
    }

    @Test
    @DisplayName("Autocomplete should display variants containing entered string")
    void testAutocomplete() {
        String originCityForAutocomplete = "Tok";

        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillOriginCityAirportInput(originCityForAutocomplete);

        Assertions.assertTrue(steps.getFirstAutocompleteText().contains(originCityForAutocomplete));
    }

    @Test
    @DisplayName("Can’t select date earlier than today's and “Returning” date cannot be earlier or same as “Departing”")
    void testDatepickerValidation() {
        String invalidDepartureDate = "12/12/2018";
        String invalidReturningDate = "12/12/2018";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

        String expectedDepartingDateInputErrorMessage = "Dates must be between " + dateFormat.format(date) + " and";
        String expectedReturningDateInputErrorMessage = "The date must be " + dateFormat.format(date) + " or after.";

        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillDateInputs(invalidDepartureDate, invalidReturningDate);
        steps.clickSubmitButton();

        Assertions.assertTrue(steps.getDepartingDateInputErrorMessage().contains(expectedDepartingDateInputErrorMessage));
        Assertions.assertTrue(steps.getReturningDateInputErrorMessage().contains(expectedReturningDateInputErrorMessage));
    }

    @Test
    @DisplayName("Hotel booking dates should be the same as flight dates")
    void testHotelBookingDates() {
        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickAddHotelCheckbox();
        Assertions.assertEquals(DEPARTURE_DATE, steps.getHotelCheckInDate());
        Assertions.assertEquals(RETURNING_DATE, steps.getHotelCheckOutDate());
    }

    @Test
    @DisplayName("Error displayed if the value in airport input is invalid")
    void testAirportInputValidation() {
        String expectedFlightOriginInputErrorMessage = "Tell us where you're flying from.";
        String expectedFlightDestinationInputErrorMessage = "Tell us where you're flying to.";

        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.clickSubmitButton();

        Assertions.assertTrue(steps.getFlightOriginInputErrorMessage().contains(expectedFlightOriginInputErrorMessage));
        Assertions.assertTrue(steps.getFlightDestinationInputErrorMessage().contains(expectedFlightDestinationInputErrorMessage));
    }

    @Test
    @DisplayName("Founded tickets should suit the filters and be sorted by the selected criteria")
    void testCheckoutPage() {
        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillAirportInputs(ORIGIN_AIRPORT, DESTINATION_AIRPORT);
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickSubmitButton();
        steps.waitUntilSearchProgressBarIsInvisible();

        String departureTicketAirline = steps.getFirstTicketAirline();
        String departureTicketAirports = steps.getFirstTicketAirports();

        steps.clickFirstTicketSelectButton();

        String returningTicketAirline = steps.getFirstTicketAirline();
        String returningTicketAirports = steps.getFirstTicketAirports();

        steps.clickFirstTicketSelectButton();

        steps.clickModalNoThanksButton();
        steps.switchTabs(1);

        Assertions.assertEquals(departureTicketAirline, steps.getFirstCheckoutTicketAirline());
        Assertions.assertEquals(returningTicketAirline, steps.getSecondCheckoutTicketAirline());
        Assertions.assertTrue(steps.getFirstCheckoutTicketFromAirport().contains(departureTicketAirports.substring(19, 22)));
        Assertions.assertTrue(steps.getFirstCheckoutTicketToAirport().contains(departureTicketAirports.substring(42, 45)));
        Assertions.assertTrue(steps.getSecondCheckoutTicketFromAirport().contains(returningTicketAirports.substring(19, 22)));
        Assertions.assertTrue(steps.getSecondCheckoutTicketToAirport().contains(returningTicketAirports.substring(42, 45)));
    }

    @Test
    @DisplayName("Founded hotels should be from the selected city")
    void testHotelBookingCity() {
        String originCityDetailed = "Frankfurt, Germany (FRA-Frankfurt Intl.)";
        String destinationCityDetailed = "Paris, France (CDG-Roissy-Charles de Gaulle)";
        String airportNameShort = "CDG";
        String airportNameFull = "Charles de Gaulle";


        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillAirportInputs(originCityDetailed, destinationCityDetailed);
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickAddHotelCheckbox();
        steps.clickSubmitButton();

        Assertions.assertTrue(steps.getFirstHotelName().contains(airportNameShort) || steps.getFirstHotelName().contains(airportNameFull));
    }

    @Test
    @DisplayName("Airports of founded tickets should be the same as previously selected ones")
    void testTicketAirports() {
        String originCityAirportNameShort = "FRA";
        String destinationCityAirportNameShort = "CDG";
        String expectedAirportsInfo = "Departure airport:\n" +
                originCityAirportNameShort + " -\n" +
                "Arrival airport:\n" +
                destinationCityAirportNameShort;

        steps.openHomePage();
        steps.navigateToFlightsTab();
        steps.fillAirportInputs(ORIGIN_AIRPORT, DESTINATION_AIRPORT);
        steps.fillDateInputs(DEPARTURE_DATE, RETURNING_DATE);
        steps.clickSubmitButton();

        Assertions.assertEquals(expectedAirportsInfo, steps.getFirstTicketAirports());
    }

    @AfterEach
    void stopBrowser() {
        steps.closeBrowser();
    }
}
