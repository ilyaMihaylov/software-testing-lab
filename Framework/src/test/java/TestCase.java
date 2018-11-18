import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class TestCase {
    private Steps steps;
    private final String DEPARTUREDATE = "12/31/2018";
    private final String RETURNINGDATE = "01/07/2019";

    @Before
    public void setUp() {
        steps = new Steps();
        steps.openBrowser();
    }

    @Test
    public void hotelDatesAreSameAsFlightDates() {
        steps.fillDatesAndCheckAddHotel(DEPARTUREDATE, RETURNINGDATE);
        Assert.assertEquals(DEPARTUREDATE, steps.getHotelCheckInDate());
        Assert.assertEquals(RETURNINGDATE, steps.getHotelCheckOutDate());
    }

    @After
    public void stopBrowser() {
        steps.closeBrowser();
    }
}
