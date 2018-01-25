package homework4.pageobjects;

import com.codeborne.selenide.SelenideElement;
import homework4.enums.DifferentElementsPageCheckboxesEnum;
import homework4.enums.DifferentElementsPageDropdownEnum;
import homework4.enums.DifferentElementsPageRadiosEnum;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    public void checkCheckboxes() {
        $$("[type=checkbox]").shouldHaveSize(4);
    }

    public void checkRadios() {
        $$("[type=radio]").shouldHaveSize(4);
    }

    public void checkDropdown() {
        $$(".colors").shouldHaveSize(1);
    }

    public void checkButtons() {
        $$(".main-content .uui-button").shouldHaveSize(2);
    }

    public void checkSections() {
        $$("section[class *= panel]").shouldHaveSize(2);
    }

    public void selectCheckbox(DifferentElementsPageCheckboxesEnum checkbox) {
        List<SelenideElement> checkboxes = $$("[type=checkbox]");
        switch (checkbox) {
            case WATER:
                checkboxes.get(0).setSelected(true);
                break;
            case EARTH:
                checkboxes.get(1).setSelected(true);
                break;
            case WIND:
                checkboxes.get(2).setSelected(true);
                break;
            case FIRE:
                checkboxes.get(3).setSelected(true);
                break;
        }
    }

    public void checkSelectedCheckbox(DifferentElementsPageCheckboxesEnum checkbox) {
        List<SelenideElement> checkboxes = $$("[type=checkbox]");
        switch (checkbox) {
            case WATER:
                checkboxes.get(0).shouldBe(selected);
                break;
            case EARTH:
                checkboxes.get(1).shouldBe(selected);
                break;
            case WIND:
                checkboxes.get(2).shouldBe(selected);
                break;
            case FIRE:
                checkboxes.get(3).shouldBe(selected);
                break;
        }
    }

    public void selectRadio(DifferentElementsPageRadiosEnum checkbox) {
        List<SelenideElement> radios = $$("[type=radio]");
        switch (checkbox) {
            case GOLD:
                radios.get(0).click();
                break;
            case SILVER:
                radios.get(1).click();
                break;
            case BRONZE:
                radios.get(2).click();
                break;
            case SELEN:
                radios.get(3).click();
                break;
        }
    }

    public void checkSelectedRadio(DifferentElementsPageRadiosEnum radio) {
        List<SelenideElement> radios = $$("[type=radio]");
        switch (radio) {
            case GOLD:
                radios.get(0).shouldBe(selected);
                break;
            case SILVER:
                radios.get(1).shouldBe(selected);
                break;
            case BRONZE:
                radios.get(2).shouldBe(selected);
                break;
            case SELEN:
                radios.get(3).shouldBe(selected);
                break;
        }
    }

    public void selectDropdown(DifferentElementsPageDropdownEnum color) {
        SelenideElement dropdown = $(".colors select");
        switch (color) {
            case RED:
                dropdown.selectOption(0);
                break;
            case GREEN:
                dropdown.selectOption(1);
                break;
            case BLUE:
                dropdown.selectOption(2);
                break;
            case YELLOW:
                dropdown.selectOption(3);
                break;
        }
    }

    public void checkChosenDropdown(DifferentElementsPageDropdownEnum color) {
        $(".colors select").getSelectedOption().shouldHave(text(color.toString()));
    }

    public <T> void checkLogs(T option, Boolean bool) {
        List<SelenideElement> logsRows = $$("section[class *= panel] li");
        for (SelenideElement row : logsRows) {
            if (row.getText().toUpperCase().contains(option.toString())) {
                if (option instanceof DifferentElementsPageCheckboxesEnum) {
                    row.shouldHave(text(bool.toString()));
                    break;
                }
                row.shouldHave(text(option.toString()));
            }
        }
    }

    //Overload
    public <T> void checkLogs(T option) {
        checkLogs(option, true);
    }

    public void unselectCheckbox(DifferentElementsPageCheckboxesEnum checkbox) {
        List<SelenideElement> checkboxes = $$("[type=checkbox]");
        switch (checkbox) {
            case WATER:
                checkboxes.get(0).setSelected(false);
                break;
            case EARTH:
                checkboxes.get(1).setSelected(false);
                break;
            case WIND:
                checkboxes.get(2).setSelected(false);
                break;
            case FIRE:
                checkboxes.get(3).setSelected(false);
                break;
        }
    }

    public void checkUnselectedCheckbox(DifferentElementsPageCheckboxesEnum checkbox) {
        List<SelenideElement> checkboxes = $$("[type=checkbox]");
        switch (checkbox) {
            case WATER:
                checkboxes.get(0).shouldNotBe(selected);
                break;
            case EARTH:
                checkboxes.get(1).shouldNotBe(selected);
                break;
            case WIND:
                checkboxes.get(2).shouldNotBe(selected);
                break;
            case FIRE:
                checkboxes.get(3).shouldNotBe(selected);
                break;
        }
    }
}