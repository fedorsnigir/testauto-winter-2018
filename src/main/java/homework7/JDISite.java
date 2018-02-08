package homework7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import homework7.entities.User;
import homework7.pages.HomePage;
import homework7.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI")
public class JDISite extends WebSite {

    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    public static void login(User user) {
        homePage.header.login(user);
    }
}
