package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class TestLesson1 {

    private WebDriver driver;
    private String Url = "https://jdi-framework.github.io/tests";
    private String login = "epam";
    private String password = "1234";

    //Create a new testSite in a new Java class, specify testSite name in accordance with checking functionality
    @Test
    public void testSite() {

        //1 Open test site by URL
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(Url);
        WebElement logo = driver.findElement(By.xpath("//*[@id = 'epam_logo']"));
        assertTrue(logo.isDisplayed());

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("Login")).sendKeys(login);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
        WebElement logoutButton = driver.findElement(By.className("logout"));
        assertTrue(logoutButton.isDisplayed());

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement usernameButton = driver.findElement(By.xpath("//*[@class = 'profile-photo']/span"));
        assertEquals(usernameButton.getText(), "PITER CHAILOVSKII");

        //5 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> mainImages = driver.findElements(By.className("benefit-icon"));
        for (WebElement element : mainImages) {
            assertTrue(element.isDisplayed());
        }

        //6 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> homePageTexts = driver.findElements(By.className("benefit-txt"));
        String[] expectedMainTexts = {
                "To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"};
        for (int i = 0; i < homePageTexts.size(); i++) {
            assertEquals(homePageTexts.get(i).getText().replace("\n", " "), expectedMainTexts[i]);
        }

        //7 Assert that there are the main header and the text below it on the Home Page
        WebElement mainTitle = driver.findElement(By.xpath("//*[contains(@class,'main-title')]"));
        String expectedMainTitle = "EPAM FRAMEWORK WISHES…";
        assertEquals(mainTitle.getText(), expectedMainTitle);
        WebElement mainText = driver.findElement(By.xpath("//*[contains(@class,'main-txt')]"));
        String expectedMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(mainText.getText().replace("\n", " "), expectedMainText);

        //8 close browser
        driver.close();
    }
}
