package homework7.pages;

import static org.testng.Assert.assertEquals;

public class HomePage extends CommonPage {

    public void checkUsername(String username) {
        assertEquals(header.usernameButton.getText(), username);
    }
}