import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {
    @Test
    public void testListOfRecentSearches(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        String url = "https://www.expedia.com/";
        String year = "2018", month = "11", day = "31";
        String recentSearchesListUrl = "https://www.expedia.com/scratchpad?recentSearches=true";
        String expectedRecentSearch = "Moscow, Russia (MOW) - Tokyo, Japan (TYO)";

        driver.get(url);

        driver.findElement(By.id("tab-flight-tab-hp")).click();
        driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();

        driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aria-option-0")));
        driver.findElement(By.id("aria-option-0")).click();

        driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("Tokyo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aria-option-0")));
        driver.findElement(By.id("aria-option-0")).click();

        driver.findElement(By.id("flight-departing-single-hp-flight")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"datepicker-cal\"]")));
        driver.findElement(By.xpath("//button[@data-year=" + year + " and @data-month=" + month + " and @data-day=" + day + "]")).click();

        driver.findElement(By.xpath("//button[@class=\"btn-primary btn-action gcw-submit\"]")).click();

        driver.navigate().to(recentSearchesListUrl);
        System.out.println();

        Assert.assertEquals(expectedRecentSearch, driver.findElement(By.xpath("//*[@class=\"group-title truncate\"]")).getText());
        driver.quit();
    }
}