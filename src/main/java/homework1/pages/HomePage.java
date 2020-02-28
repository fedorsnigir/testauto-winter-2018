package homework1.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import homework1.entities.User;
import homework1.forms.LoginForm;

public class HomePage extends WebPage {

    public LoginForm loginForm;

    @XPath("//*[contains(@class,'nav')]//a") public Menu headerMenu;
    @Css(".profile-photo") public Button profilePhoto;
    @Css("#user-name") public Button username;

    public void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    public String getUserName() {
        return username.getText();
    }
}