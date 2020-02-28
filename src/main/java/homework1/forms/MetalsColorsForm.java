package homework1.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import homework1.entities.MetalsColorsParameters;
import homework1.enums.metalsColors.VegetablesEnum;

import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsParameters> {

    @Css("#summary-block p") public RadioButtons summary;
    @Css("#summary-block input") public RadioButtons summaryValues;
    @Css("#elements-checklist p") public Checklist elements;
    @Css("#elements-checklist input") public Checklist elementsValues;
    @JDropdown(root = "#colors", value = "span", list = "li", expand = ".caret") public Dropdown colors;
    @JDropdown(root = "#metals", value = "span", list = "li", expand = ".caret") public Dropdown metals;
    @JDropdown(root = "#vegetables", value = "span", list = "li", expand = ".caret") public Dropdown vegetables;
    @Css("#submit-button") public Button submitButton;

    public void fillForm(MetalsColorsParameters parameters) {

        List<String> summaryValuesList = summaryValues.values();
        for (int i = 0; i < parameters.summary.size(); i++) {
            int index = summaryValuesList.indexOf(parameters.summary.get(i).toString());
            summary.select(index + 1);
        }

        List<String> elementsValuesList = elementsValues.values();
        for (int i = 0; i < parameters.elements.size(); i++) {
            int index = elementsValuesList.indexOf(parameters.elements.get(i).toString());
            elements.select(index + 1);
        }

        colors.select(parameters.color);

        metals.select(parameters.metals);

        vegetables.select(VegetablesEnum.VEGETABLES);
        for(VegetablesEnum veg: parameters.vegetables) {
            vegetables.select(veg);
        }
    }

    public void submit() {
        submitButton.click();
    }
}