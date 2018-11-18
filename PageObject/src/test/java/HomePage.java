import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class HomePage extends AbstractPage {
    @FindBy(id = "header-language-2058")
    private WebElement changeLanguageToSpanishButton;

    @FindBy(id = "header-language-2052")
    private WebElement changeLanguageToChineseButton;

    @FindBy(id = "header-language-1033")
    private WebElement changeLanguageToEnglishButton;

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    void changeLanguage(String language) {
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

    String getPageTitle() {
        return driver.getTitle();
    }
}
