package homework4.pageobjects;

import com.codeborne.selenide.SelenideElement;
import homework3.enums.User;
import homework4.enums.*;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static homework4.enums.ServiceMenuOptionsEnum.DATES;
import static homework4.enums.ServiceMenuOptionsEnum.DIFFERENT_ELEMENTS;

public class IndexPage {

    private String url = "https://jdi-framework.github.io/tests";

    public void openPage() {
        open(url);
    }

    public void checkLogo() {
        $(".epam-logo").shouldBe(visible);
    }

    public void login(User login, User password) {
        $(".profile-photo").click();
        $("#Login").setValue(login.value);
        $("#Password").setValue(password.value);
        $("[type = submit]").click();
    }

    public void checkLogin() {
        $("[class = logout]").shouldBe(visible);
    }

    public void checkUsername(User username) {
        $(".profile-photo > span").shouldHave(text(username.value));
    }

    public void checkMainImages(int count) {
        List<SelenideElement> mainImages = $$(".benefit-icon").shouldHaveSize(count);
        for (SelenideElement element : mainImages) {
            element.shouldBe(visible);
        }
    }

    public void checkMainTexts(IndexPageMainTextsEnum[] expectedMainTexts) {
        List<SelenideElement> mainTexts = $$(".benefit-txt");
        for (int i = 0; i < mainTexts.size(); i++) {
            mainTexts.get(i).shouldHave(text(expectedMainTexts[i].text));
        }
    }

    public void checkMainTitle(IndexPageMainTitleEnum expectedMainTitle) {
        $(".main-title").shouldHave(text(expectedMainTitle.text));
    }

    public void checkHomeText(IndexPageHomeTextEnum expectedHomeText) {
        $(".main-txt").shouldHave(text(expectedHomeText.text));
    }

    public void expandServiceMenu(ServiceMenusEnum menu) {
        switch (menu) {
            case TOPMENU:
                $("[class = dropdown]").click();
                break;
            case LEFTMENU:
                $(".sub-menu").click();
                break;
        }
    }

    public void checkServiceMenuOptions(ServiceMenusEnum menu, ServiceMenuOptionsEnum[] expectedServiceMenuOptionsEnum) {
        List<SelenideElement> serviceMenuOptions = null;
        switch (menu) {
            case TOPMENU:
                serviceMenuOptions = $$(".dropdown-menu a");
                break;
            case LEFTMENU:
                serviceMenuOptions = $$(".sub a");
                break;
        }
        for (int i = 0; i < serviceMenuOptions.size(); i++) {
            serviceMenuOptions.get(i).shouldHave(text(expectedServiceMenuOptionsEnum[i].toString()));
        }
    }

    public DifferentElementsPage openDifferentsElementsPage() {
        List<SelenideElement> options = $$(".dropdown li");
        for (SelenideElement option : options) {
            if (option.getText().equalsIgnoreCase(DIFFERENT_ELEMENTS.toString())){
                option.click();
            }
        }
        return page(DifferentElementsPage.class);
    }

    public DatesPage openDatesPage() {
        List<SelenideElement> options = $$(".dropdown li");
        for (SelenideElement option : options) {
            if (option.getText().equalsIgnoreCase(DATES.toString())){
                option.click();
            }
        }
        return page(DatesPage.class);
    }

    public void logout() {
        $(".profile-photo").click();
        $("[class = logout]").click();
    }
}