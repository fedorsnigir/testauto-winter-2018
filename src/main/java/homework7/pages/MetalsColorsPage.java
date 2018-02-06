//package homework7.pages;
//
//import com.epam.jdi.uitests.web.selenium.elements.complex.*;
//import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
//import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
//import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
//import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
//import com.epam.web.matcher.testng.Assert;
//import homework7.enums.MetalsAndColors.*;
//import org.openqa.selenium.support.FindBy;
//
//public class MetalsColorsPage extends CommonPage {
//
//    @FindBy(css = "#summary-block p")
//    public RadioButtons radioButtons;
//
//    @FindBy(css = "#elements-block p")
//    public CheckList<ElementsEnum> elements;
//
//    @JDropdown(
//            root = @FindBy(css = ".colors"),
//            list = @FindBy(css = "li"))
//    public Dropdown<ColorsEnum> colors;
//
//    @JComboBox(
//            root = @JFindBy(css = ".metals"),
//            list = @JFindBy(css = "li"),
//            expand = @JFindBy(css = ".caret"))
//    public ComboBox<MetalsEnum> metals;
//
//    @JDropList(
//            jroot = @JFindBy(css = ".salad"),
//            jlist = @JFindBy(css = "li"),
//            jvalue = @JFindBy(css = "button"))
//    public DropList vegetables;
//
//    public void selectRadioButton(int... numbers) {
//        for (int number : numbers) {
//            radioButtons.select(String.valueOf(number));
//        }
//    }
//
//    public void selectCheckbox(ElementsEnum... elements) {
//        for (ElementsEnum element : elements) {
//            this.elements.select(element);
//        }
//    }
//
//    public <T extends Enum> void selectDropdown(DropdownsEnum dropdown, T... options) {
//        switch (dropdown) {
//            case COLORS:
//                colors.select((ColorsEnum) options[0]);
//                break;
//            case METALS:
//                metals.select((MetalsEnum) options[0]);
//                break;
//            case VEGETABLES:
//                vegetables.select(options);
//                break;
//        }
//    }
//
//    public void checkRadioButton(int number) {
//        Assert.isTrue(radioButtons.isSelected(String.valueOf(number)));
//    }
//}