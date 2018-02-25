package homework3.pageobjects;

import homework3.enums.IndexPageHomeTextEnum;
import homework3.enums.IndexPageMainTextsEnum;
import homework3.enums.IndexPageMainTitleEnum;
import homework3.enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    private WebDriver driver;
    private String url = "https://jdi-framework.github.io/tests";

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

    public void openPage() {
        driver.get(url);
    }

    public void checkLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void login(User login, User password) {
        profilePhoto.click();
        loginInput.sendKeys(login.value);
        passwordInput.sendKeys(password.value);
        submitBtn.click();
    }

    public void checkLogin() {
        assertTrue(logoutButton.isDisplayed());
    }

    public void checkUsername(User username) {
        assertEquals(usernameButton.getText(), username.value);
    }

    public void checkMainImages(int count) {
        assertEquals(mainImages.size(), count);
        for (WebElement element : mainImages) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkMainTexts(IndexPageMainTextsEnum[] expectedMainTexts) {
        for (int i = 0; i < mainTexts.size(); i++) {
            assertEquals(mainTexts.get(i).getText().replace("\n", " "), expectedMainTexts[i].text);
        }
    }

    public void checkMainTitle(IndexPageMainTitleEnum expectedMainTitle) {
        assertEquals(mainTitle.getText(), expectedMainTitle.text);
    }

    public void checkHomeText(IndexPageHomeTextEnum expectedHomeText) {
        assertEquals(homeText.getText().replace("\n", " "), expectedHomeText.text);
    }
}