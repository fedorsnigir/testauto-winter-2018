//package homework7.sections;
//
//import com.epam.jdi.uitests.web.selenium.elements.common.Button;
//import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
//import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
//import homework7.entities.User;
//import homework7.enums.MainMenuOptionsEnum;
//import org.openqa.selenium.support.FindBy;
//
//public class Header extends Section {
//
//    @FindBy(css = ".profile-photo")
//    public Button profilePhoto;
//
//    @FindBy(className = "logout")
//    public Button logoutButton;
//
//    @FindBy(xpath = "//*[@class = 'profile-photo']/span")
//    public Button usernameButton;
//
//    @FindBy(css = ".m-l8")
//    public Menu<MainMenuOptionsEnum> menu;
//
//    public LoginForm loginForm;
//
//    public void login(User user) {
//        profilePhoto.click();
//        loginForm.loginAs(user);
//    }
//}
