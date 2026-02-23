package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By settingsForm = By.cssSelector(".settings-page form");
    private final By imageUrlInput = By.cssSelector(".settings-page input[placeholder*='URL'], .settings-page input[type='text']");
    private final By usernameInput = By.cssSelector(".settings-page input[placeholder='Username']");
    private final By bioTextarea = By.cssSelector(".settings-page textarea");
    private final By emailInput = By.cssSelector(".settings-page input[type='email']");
    private final By passwordInput = By.cssSelector(".settings-page input[type='password']");
    private final By updateSettingsButton = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'Update')]");
    private final By logoutButton = By.xpath("//button[contains(@class,'btn-outline-danger') or contains(.,'Logout')]");


    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
