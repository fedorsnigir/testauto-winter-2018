package homework3;

import homework3.pageobjects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static homework3.enums.User.*;

public class TestClass {

    private String url = "https://jdi-framework.github.io/tests";
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void initializeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
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

        //1 Check open test site by URL
        indexPage.checkLogo();

        //2 Assert Browser title
        indexPage.checkTitle();

        //3 Perform login
        indexPage.performLogin(LOGIN, PASSWORD);
        indexPage.checkLogin();

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(USERNAME);

        //5 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkMainImages(4);

        //6 Assert that there are 4 texts on the Home Page and check them by getting texts
        String[] expectedMainTexts = {
                "To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"};
        indexPage.checkMainTexts(expectedMainTexts);

        //7 Assert that there are the main header and the text below it on the Home Page
        String expectedMainTitle = "EPAM FRAMEWORK WISHES…";
        indexPage.checkMainTitle(expectedMainTitle);

        String expectedHomeText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        indexPage.checkHomeText(expectedHomeText);
    }
}
