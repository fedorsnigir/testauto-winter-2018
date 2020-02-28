package homework1.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class ResultSection extends Section {

    @FindBy(css = "ul[class*=results]")
    public TextArea resultsSection;

    /*
    public <T> void checkResults(T... option) {
        String[] logs = resultsSection.getLines();
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
     */
}
