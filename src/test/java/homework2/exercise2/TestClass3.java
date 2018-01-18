package homework2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass3 {
    private WebDriver driver;
    private String url = "https://jdi-framework.github.io/tests";
    private String login = "epam";
    private String password = "1234";

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    @BeforeClass(alwaysRun = true)
    public void login(){
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("Login")).sendKeys(login);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
    }

    //3 Perform login
    @Test(groups = "Regression")
    public void testLogin() {
        WebElement logoutButton = driver.findElement(By.className("logout"));
        assertTrue(logoutButton.isDisplayed());
    }

    //4 Assert User name in the left-top side of screen that user is loggined
    @Test(groups = "Regression")
    public void testUsername() {
        WebElement usernameButton = driver.findElement(By.xpath("//*[@class = 'profile-photo']/span"));
        assertEquals(usernameButton.getText(), "PITER CHAILOVSKII");
    }
}
