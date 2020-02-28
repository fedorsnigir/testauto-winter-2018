package homework1;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homework1.pages.HomePage;
import homework1.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI")
public class JDISite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;
}
