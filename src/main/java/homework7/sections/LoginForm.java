package homework7.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import homework7.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(id = "Login")
    public TextField login;

    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = "form [type = submit]")
    public Button submit;
}
