package homework2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestClass1 {
    private WebDriver driver;
    private String url = "https://jdi-framework.github.io/tests";

    @DataProvider(parallel = true)
    public Object[][] get4Texts() {
        return new Object[][]{
                {"To include good practices and ideas from successful EPAM projec"},
                {"To be flexible and customizable"},
                {"To be multiplatform"},
                {"Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
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

    //6 Assert that there are 4 texts on the Home Page and check them by getting texts
    @Test(groups = {"Smoke", "Regression"}, dataProvider = "get4Texts")
    public void test4Texts(String text) {
        List<WebElement> homePageTextElements = driver.findElements(By.className("benefit-txt"));
        List<String> homePageTexts = new ArrayList<String>();
        for (WebElement element : homePageTextElements) {
            homePageTexts.add(element.getText().replace("\n", " "));
        }
        assertTrue(homePageTexts.contains(text));
    }
}
