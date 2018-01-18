package homework2.exercise1and2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass1 {
    private WebDriver driver;
    private String Url = "https://jdi-framework.github.io/tests";

   @BeforeClass(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    //1 Open test site by URL
    @Test(groups = "Smoke")
    public void testOpeningSite() {
        WebElement logo = driver.findElement(By.xpath("//*[@id = 'epam_logo']"));
        assertTrue(logo.isDisplayed());
    }

    //2 Assert Browser title
    @Test(groups = "Smoke")
    public void testSiteTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }
}
