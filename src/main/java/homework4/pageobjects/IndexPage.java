package homework4.pageobjects;

import com.codeborne.selenide.SelenideElement;
import homework4.enums.*;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static homework4.enums.ServiceMenusEnum.TOPMENU;

public class IndexPage {

    public void checkLogo() {
        $(".epam-logo").shouldBe(visible);
    }

    public void performLogin(String login, String password) {
        $(".profile-photo").click();
        $("#Login").setValue(login);
        $("#Password").setValue(password);
        $("[type = submit]").click();
    }

    public void checkLogin() {
        $(".logout").shouldBe(visible);
    }

    public void checkUsername(String username) {
        $(".profile-photo > span").shouldHave(text(username));
    }

    public void checkMainImages() {
        List<SelenideElement> mainImages = $$(".benefit-icon");
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
            serviceMenuOptions.get(i).shouldHave(text(expectedServiceMenuOptionsEnum[i].text));
        }
    }

    public Object openServiceMenuOption(ServiceMenuOptionsEnum serviceMenuOption) {
        switch (serviceMenuOption.text) {
            case "SUPPORT":
                $("[href*='page3']").click();
                break;
            case "DATES":
                $("[href*='page4']").click();
                break;
            case "COMPLEX TABLE":
                $("[href*='page5']").click();
                break;
            case "SIMPLE TABLE":
                $("[href*='page6']").click();
                break;
            case "TABLE WITH PAGES":
                $("[href*='page7']").click();
                break;
            case "DIFFERENT ELEMENTS":
                $("[href*='page8']").click();
                return new DifferentElementsPage();
        }
        return null;
    }
}