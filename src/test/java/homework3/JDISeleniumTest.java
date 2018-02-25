package homework3;

import homework3.enums.IndexPageMainTextsEnum;
import homework3.pageobjects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static homework3.enums.IndexPageHomeTextEnum.HOME_TEXT;
import static homework3.enums.IndexPageMainTitleEnum.TITLE;
import static homework3.enums.User.*;

public class JDISeleniumTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void initialize() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = new IndexPage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        if (!driver.toString().contains("null")) {
            driver.quit();
        }
    }

    //Create a new testSite in a new Java class, specify testSite name in accordance with checking functionality
    @Test
    public void testSite() {

        //1 Check openPage test site by URL
        indexPage.openPage();
        indexPage.checkLogo();

        //2 Assert Browser title
        indexPage.checkTitle();

        //3 Perform login
        indexPage.login(LOGIN, PASSWORD);
        indexPage.checkLogin();

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(USERNAME);

        //5 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkMainImages(4);

        //6 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkMainTexts(IndexPageMainTextsEnum.values());

        //7 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkMainTitle(TITLE);
        indexPage.checkHomeText(HOME_TEXT);
    }
}
