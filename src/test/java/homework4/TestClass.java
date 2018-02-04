package homework4;

import com.codeborne.selenide.Configuration;
import homework4.enums.IndexPageMainTextsEnum;
import homework4.enums.ServiceMenuOptionsEnum;
import homework4.pageobjects.DifferentElementsPage;
import homework4.pageobjects.IndexPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static homework4.enums.DifferentElementsPageCheckboxesEnum.WATER;
import static homework4.enums.DifferentElementsPageCheckboxesEnum.WIND;
import static homework4.enums.DifferentElementsPageDropdownEnum.YELLOW;
import static homework4.enums.DifferentElementsPageRadiosEnum.SELEN;
import static homework4.enums.IndexPageHomeTextEnum.HOME_TEXT;
import static homework4.enums.IndexPageMainTitleEnum.TITLE;
import static homework4.enums.ServiceMenusEnum.LEFTMENU;
import static homework4.enums.ServiceMenusEnum.TOPMENU;

public class TestClass {
    private String url = "https://jdi-framework.github.io/tests";
    private String login = "epam";
    private String password = "1234";
    private String username = "PITER CHAILOVSKII";
    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void initializeBrowser() {
        Configuration.browser = "CHROME";
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
    }

    @BeforeMethod
    public void openSite() {
        open(url);
        indexPage = new IndexPage();
    }

    @AfterClass
    public void closeBrowser() {
        close();
    }

    //Create a new testSite in a new Java class, specify testSite name in accordance with checking functionality
    @Test
    public void testSite() {

        //1 Check open test site by URL
        indexPage.checkLogo();

        //2 Perform login
        indexPage.performLogin(login, password);
        indexPage.checkLogin();

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(username);

        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkMainImages();
        indexPage.checkMainTexts(IndexPageMainTextsEnum.values());
        indexPage.checkMainTitle(TITLE);
        indexPage.checkHomeText(HOME_TEXT);

        //5 Click on Service subcategory in the header and check that drop down contains options
        indexPage.expandServiceMenu(TOPMENU);
        indexPage.checkServiceMenuOptions(TOPMENU, ServiceMenuOptionsEnum.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.expandServiceMenu(LEFTMENU);
        indexPage.checkServiceMenuOptions(LEFTMENU, ServiceMenuOptionsEnum.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.expandServiceMenu(TOPMENU);
        differentElementsPage = indexPage.openDifferentsElementsPage();

        //8 Check interface on Service page, it contains all needed elements.
        differentElementsPage.checkCheckboxes();
        differentElementsPage.checkRadios();
        differentElementsPage.checkDropdown();
        differentElementsPage.checkButtons();
        differentElementsPage.checkSections();

        //9 Select and assert checkboxes
        differentElementsPage.selectCheckbox(WATER, true);
        differentElementsPage.selectCheckbox(WIND, true);
        differentElementsPage.checkSelectedCheckbox(WATER, true);
        differentElementsPage.checkSelectedCheckbox(WIND, true);

        //10 Select radio
        differentElementsPage.selectRadio(SELEN);
        differentElementsPage.checkSelectedRadio(SELEN);

        //11 Select in dropdown
        differentElementsPage.selectDropdown(YELLOW);
        differentElementsPage.checkChosenDropdown(YELLOW);

        //12 Check in logs section selected values and status (true|false)
        differentElementsPage.checkLogs(WATER, true);
        differentElementsPage.checkLogs(WIND, true);
        differentElementsPage.checkLogs(SELEN);
        differentElementsPage.checkLogs(YELLOW);

        //13 Unselect and assert checkboxes
        differentElementsPage.selectCheckbox(WATER, false);
        differentElementsPage.selectCheckbox(WIND, false);
        differentElementsPage.checkSelectedCheckbox(WATER, false);
        differentElementsPage.checkSelectedCheckbox(WIND, false);

        //14 Check in logs section unselected values and status (true|false)
        differentElementsPage.checkLogs(WATER, false);
        differentElementsPage.checkLogs(WIND, false);
    }
}
