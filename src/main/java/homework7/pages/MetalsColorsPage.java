package homework7.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.junit.Assert;
import homework7.enums.MetalsAndColors.*;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsPage extends CommonPage {

    @FindBy(css = "#summary-block label")
    public RadioButtons radioButtons;

    @FindBy(css = "#elements-block p")
    public CheckList<ElementsEnum> elements;

    @FindBy(css = "#submit-button")
    public Button submit;

    @FindBy(css = "ul[class*=results]")
    public TextArea logsSection;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(css = "li"))
    public Dropdown<ColorsEnum> colors;

    @JComboBox(
            root = @JFindBy(css = ".metals"),
            list = @JFindBy(css = "li"),
            expand = @JFindBy(css = ".caret"))
    public ComboBox<MetalsEnum> metals;

    @JDropdown(
            root = @FindBy(css = ".salad"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "button"))
    public Dropdown<VegetablesEnum> vegetables;

    public void selectRadioButton(int... numbers) {
        for (int number : numbers) {
            radioButtons.select(String.valueOf(number));
        }
    }

    public void selectCheckbox(ElementsEnum element) {
        elements.select(element);
    }

    public void clearVegetables() {
        vegetables.select("Salad");
    }

    public <T extends Enum> void selectDropdown(DropdownsEnum dropdown, T option) {
        switch (dropdown) {
            case COLORS:
                colors.select((ColorsEnum) option);
                break;
            case METALS:
                metals.select((MetalsEnum) option);
                break;
            case VEGETABLES:
                vegetables.select((VegetablesEnum) option);
                break;
        }
    }

    public void submit() {
        submit.click();
    }

    public <T> void checkLogs(T... option) {
        String[] logs = logsSection.getLines();
        if (option[0] instanceof Integer) {
            int sum = 0;
            for (int i = 0; i < option.length; i++) {
                sum += (Integer) option[i];
            }
            for (String line : logs) {
                if (line.contains("Summary")) {
                    Assert.isTrue(line.contains(String.valueOf(sum)));
                }
            }
        } else if (option[0] instanceof ElementsEnum) {
            for (String line : logs) {
                if (line.toUpperCase().contains(option[0].toString())) {
                    Assert.isTrue(line.contains("Elements"));
                }
            }
        } else if (option[0] instanceof ColorsEnum) {
            for (String line : logs) {
                if (line.toUpperCase().contains(option[0].toString())) {
                    Assert.isTrue(line.contains("Color"));
                }
            }
        } else if (option[0] instanceof MetalsEnum) {
            for (String line : logs) {
                if (line.toUpperCase().contains(option[0].toString())) {
                    Assert.isTrue(line.contains("Metal"));
                }
            }
        } else if (option[0] instanceof VegetablesEnum) {
            for (String line : logs) {
                if (line.toUpperCase().contains(option[0].toString())) {
                    Assert.isTrue(line.contains("Vegetables"));
                }
            }
        }
    }
}