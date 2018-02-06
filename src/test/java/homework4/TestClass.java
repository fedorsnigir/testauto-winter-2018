package homework4;

import homework3.enums.User;
import homework4.enums.IndexPageMainTextsEnum;
import homework4.enums.ServiceMenuOptionsEnum;
import homework4.pageobjects.DatesPage;
import homework4.pageobjects.DifferentElementsPage;
import homework4.pageobjects.IndexPage;
import homework4.utils.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homework4.enums.DifferentElementsPageCheckboxesEnum.WATER;
import static homework4.enums.DifferentElementsPageCheckboxesEnum.WIND;
import static homework4.enums.DifferentElementsPageDropdownEnum.YELLOW;
import static homework4.enums.DifferentElementsPageRadiosEnum.SELEN;
import static homework4.enums.IndexPageHomeTextEnum.HOME_TEXT;
import static homework4.enums.IndexPageMainTitleEnum.TITLE;
import static homework4.enums.ServiceMenusEnum.LEFTMENU;
import static homework4.enums.ServiceMenusEnum.TOPMENU;
import static homework4.enums.SliderEnum.LEFT;
import static homework4.enums.SliderEnum.RIGHT;

public class TestClass extends Configuration {
    private String url = "https://jdi-framework.github.io/tests";

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;
    private DatesPage datesPage;

    @BeforeClass
    public void openSite() {
        open(url);
        indexPage = page(IndexPage.class);
    }

    @AfterClass
    public void closeBrowser() {
        close();
    }

    @Test
    public void testCase1() {

        //1 Check open test site by URL
        indexPage.checkLogo();

        //2 Perform login
        indexPage.performLogin(User.LOGIN, User.PASSWORD);
        indexPage.checkLogin();

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(User.USERNAME);

        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkMainImages(4);
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

    @Test
    public void testCase2() {

        //1 Check open test site by URL
        indexPage.checkLogo();

        //2 Perform login
        indexPage.performLogin(User.LOGIN, User.PASSWORD);
        indexPage.checkLogin();

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUsername(User.USERNAME);

        //4 Open Service -> Dates
        indexPage.expandServiceMenu(TOPMENU);
        datesPage = indexPage.openDatesPage();
        datesPage.checkPageIsOpened();

        //--- Using drag-and-drop set Range sliders ---

        //5 left sliders - the most left position, right moveSlider - the most rigth position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 100);
        datesPage.checkSlider(LEFT, 0);
        datesPage.checkSlider(RIGHT, 100);

        //6 left sliders - the most left position, right moveSlider - the most left position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 0);
        datesPage.checkSlider(LEFT, 0);
        datesPage.checkSlider(RIGHT, 0);

        //7 left sliders - the most rigth position, right moveSlider - the most rigth position
        datesPage.moveSlider(RIGHT, 100);
        datesPage.moveSlider(LEFT, 100);
        datesPage.checkSlider(RIGHT, 100);
        datesPage.checkSlider(LEFT, 100);

        //8 left - 30, right - 70	Range is set. Check sliders values
        datesPage.moveSlider(LEFT, 30);
        datesPage.moveSlider(RIGHT, 70);
        datesPage.checkSlider(LEFT, 30);
        datesPage.checkSlider(RIGHT, 70);
    }
}
