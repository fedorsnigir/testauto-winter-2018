//package homework7;
//
//import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
//import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
//import homework7.entities.User;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
//import static homework7.JDISite.*;
//import static homework7.enums.MainMenuOptionsEnum.METALS_COLORS;
//import static homework7.enums.MetalsAndColors.ColorsEnum.RED;
//import static homework7.enums.MetalsAndColors.DropdownsEnum.*;
//import static homework7.enums.MetalsAndColors.ElementsEnum.WATER;
//import static homework7.enums.MetalsAndColors.ElementsEnum.WIND;
//import static homework7.enums.MetalsAndColors.MetalsEnum.SELEN;
//import static homework7.enums.MetalsAndColors.VegetablesEnum.CUCUMBER;
//import static homework7.enums.MetalsAndColors.VegetablesEnum.TOMATO;
//
//public class TestClass extends TestNGBase {
//
//    private String login = "epam";
//    private String password = "1234";
//    private String username = "PITER CHAILOVSKII";
//
//    @BeforeSuite(alwaysRun = true)
//    public void initialize() {
//        WebSite.init(JDISite.class);
//        logger.info("Run Tests");
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//    }
//
//    @Test
//    public void testJDISite() throws InterruptedException {
//        homePage.open();
//
//        //1 Login on JDI site as User
//        login(new User(login, password));
//        homePage.checkUsername(username);
//
//        //2 Open Metals & Colors page by Header menu
//        homePage.header.menu.select(METALS_COLORS);
//        metalsColorsPage.checkOpened();
//
//        //3 Fill form Metals & Colors by data
//        metalsColorsPage.selectRadioButton(3, 8);
//        metalsColorsPage.selectCheckbox(WATER, WIND);
//        metalsColorsPage.selectDropdown(COLORS, RED);
//        metalsColorsPage.selectDropdown(METALS, SELEN);
//        metalsColorsPage.selectDropdown(VEGETABLES, CUCUMBER, TOMATO);
//        Thread.sleep(3000);
//
//        //4 Submit form Metals & Colors
//
//        //5 Result sections should contains data below:
//
//    }
//}
