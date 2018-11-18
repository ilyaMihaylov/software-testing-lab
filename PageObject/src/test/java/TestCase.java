import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class TestCase {
    private WebDriver driver;

    @Before
    public void setUp() {
        String url = "https://www.expedia.com/";

        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        driver.get(url);
    }

    @Test
    public void testInternationalization() {
        String expectedEnglishTitle = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        String expectedSpanishTitle = "Expedia: hoteles, vuelos, renta de autos, cruceros y rentas vacacionales | Expedia";
        String expectedChineseTitle = "旅行预订网站：特价酒店预订，机票查询，自游行网上优惠 | Expedia.com";

        HomePage home = new HomePage(driver);

        Assert.assertEquals(expectedEnglishTitle, home.getPageTitle());

        home.changeLanguage("Spanish");
        Assert.assertEquals(expectedSpanishTitle, home.getPageTitle());

        home.changeLanguage("Chinese");
        Assert.assertEquals(expectedChineseTitle, home.getPageTitle());

        home.changeLanguage("English");
        Assert.assertEquals(expectedEnglishTitle, home.getPageTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
