package homework2.exercise1and2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass3 {
    private WebDriver driver;
    private String url = "https://jdi-framework.github.io/tests";

    @DataProvider(name = "4 texts")
    public Object[][] getDataForTest4Texts() {
        return new Object[][]{{
                "To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"}};
    }

    @BeforeClass(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    //5 Assert that there are 4 images on the Home Page and they are displayed
    @Test(groups = {"Smoke", "Regression"})
    public void test4MainImages() {
        List<WebElement> mainImages = driver.findElements(By.className("benefit-icon"));
        for (WebElement element : mainImages) {
            assertTrue(element.isDisplayed());
        }
    }

    //6 Assert that there are 4 texts on the Home Page and check them by getting texts
    @Test(groups = {"Smoke", "Regression"}, dataProvider = "4 texts")
    public void test4Texts(String[] texts) {
        List<WebElement> homePageTexts = driver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < homePageTexts.size(); i++) {
            assertEquals(homePageTexts.get(i).getText().replace("\n", " "), texts[i]);
        }
    }

    //7 Assert that there are the main header and the text below it on the Home Page
    @Test(groups = {"Smoke", "Regression"})
    public void testMainHeader() {
        WebElement mainTitle = driver.findElement(By.xpath("//*[contains(@class,'main-title')]"));
        String expectedMainTitle = "EPAM FRAMEWORK WISHES…";
        assertEquals(mainTitle.getText(), expectedMainTitle);
        WebElement mainText = driver.findElement(By.xpath("//*[contains(@class,'main-txt')]"));
        String expectedMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(mainText.getText().replace("\n", " "), expectedMainText);
    }
}
