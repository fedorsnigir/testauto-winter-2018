package homework1.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homework1.entities.MetalsColorsParameters;
import homework1.forms.MetalsColorsForm;
import homework1.sections.ResultSection;

public class MetalsColorsPage extends WebPage {

    public MetalsColorsForm metalsColorsForm;
    public ResultSection resultSection;

    public void submit() {
        metalsColorsForm.submit();
    }

    public void fill(MetalsColorsParameters parameters) {
        metalsColorsForm.fillForm(parameters);
    }
}