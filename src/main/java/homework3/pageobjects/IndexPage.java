package homework3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id = 'epam_logo']")
    private WebElement logo;

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "Login")
    private WebElement loginInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@type = 'submit']")
    private WebElement submitBtn;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@class = 'profile-photo']/span")
    private WebElement usernameButton;

    @FindBy(className = "benefit-icon")
    private List<WebElement> mainImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> mainTexts;

    @FindBy(xpath = "//*[contains(@class,'main-title')]")
    private WebElement mainTitle;

    @FindBy(xpath = "//*[contains(@class,'main-txt')]")
    private WebElement homeText;


    public void checkLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void performLogin(String login, String password) {
        profilePhoto.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }

    public void checkLogin() {
        assertTrue(logoutButton.isDisplayed());
    }

    public void checkUsername() {
        assertEquals(usernameButton.getText(), "PITER CHAILOVSKII");
    }

    public void checkMainImages() {
        for (WebElement element : mainImages) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkMainTexts(String[] expectedMainTexts) {
        for (int i = 0; i < mainTexts.size(); i++) {
            assertEquals(mainTexts.get(i).getText().replace("\n", " "), expectedMainTexts[i]);
        }
    }

    public void checkMainTitle(String expectedMainTitle) {
        assertEquals(mainTitle.getText(), expectedMainTitle);
    }

    public void checkHomeText(String expectedHomeText) {
        assertEquals(homeText.getText().replace("\n", " "), expectedHomeText);
    }

}