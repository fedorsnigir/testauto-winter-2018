package homework4.utils;

import org.testng.annotations.BeforeSuite;

public class Configuration {
    @BeforeSuite
    public void initializeBrowser() {
        com.codeborne.selenide.Configuration.browser = "CHROME";
        com.codeborne.selenide.Configuration.screenshots = true;
        com.codeborne.selenide.Configuration.reportsFolder = "build/reports/tests";
    }
}
