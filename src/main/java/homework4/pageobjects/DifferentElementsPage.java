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

    public void selectCheckbox(DifferentElementsPageCheckboxesEnum checkbox, Boolean bool) {
        List<SelenideElement> checkboxesNames = $$(".label-checkbox");
        List<SelenideElement> checkboxes = $$(".label-checkbox input");
        for (int i = 0; i < checkboxesNames.size(); i++) {
            if (checkboxesNames.get(i).getText().equalsIgnoreCase(checkbox.toString())) {
                checkboxes.get(i).setSelected(bool);
            }
        }
    }

    public void checkSelectedCheckbox(DifferentElementsPageCheckboxesEnum checkbox, Boolean bool) {
        List<SelenideElement> checkboxesNames = $$(".label-checkbox");
        List<SelenideElement> checkboxes = $$(".label-checkbox input");
        for (int i = 0; i < checkboxesNames.size(); i++) {
            if (checkboxesNames.get(i).getText().equalsIgnoreCase(checkbox.toString())) {
                if (bool) {
                    checkboxes.get(i).shouldBe(checked);
                } else {
                    checkboxes.get(i).shouldNotBe(checked);
                }
            }
        }
    }

    public void selectRadio(DifferentElementsPageRadiosEnum radio) {
        List<SelenideElement> radios = $$(".label-radio");
        for (SelenideElement element : radios) {
            if (element.getText().equalsIgnoreCase(radio.toString())) {
                element.click();
            }
        }
    }

    public void checkSelectedRadio(DifferentElementsPageRadiosEnum radio) {
        List<SelenideElement> radios = $$("[type=radio]");
        for (SelenideElement element : radios) {
            if (element.getText().equalsIgnoreCase(radio.toString())) {
                element.shouldBe(selected);
            }
        }
    }

    public void selectDropdown(DifferentElementsPageDropdownEnum color) {
        SelenideElement dropdown = $(".colors select");
        dropdown.selectOption(color.name);
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
}