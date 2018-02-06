package homework4.pageobjects;

import com.codeborne.selenide.SelenideElement;
import homework4.enums.SliderEnum;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static homework4.enums.ServiceMenuOptionsEnum.DATES;

public class DatesPage {

    public void checkPageIsOpened() {
        Assert.assertTrue(title().equalsIgnoreCase(DATES.toString()));
    }

    public void moveSlider(SliderEnum slider, int position) {
        List<SelenideElement> sliders = $$("[type=range] a");
        SelenideElement chosenSlider = null;
        switch (slider) {
            case LEFT:
                chosenSlider = sliders.get(0);
                break;
            case RIGHT:
                chosenSlider = sliders.get(1);
                break;
        }
        int range = $("[type=range]").getSize().width;
        int actualPosition = Integer.parseInt(chosenSlider.$("span").getText());
        int delta = Math.round((float) (position - actualPosition) * range / 100) - 2;
        actions().dragAndDropBy(chosenSlider, delta, 0).perform();
    }

    public void checkSlider(SliderEnum slider, int position) {
        List<SelenideElement> sliders = $$("[type=range] a");
        SelenideElement chosenSlider = null;
        switch (slider) {
            case LEFT:
                chosenSlider = sliders.get(0);
                break;
            case RIGHT:
                chosenSlider = sliders.get(1);
                break;
        }
        chosenSlider.$("span").shouldHave(text(String.valueOf(position)));
    }
}