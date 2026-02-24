package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By imageUrlInput = By.cssSelector(".settings-page input[placeholder*='URL'], .settings-page input[type='text']");
    private final By usernameInput = By.cssSelector(".settings-page input[placeholder='Username']");
    private final By bioTestInput = By.cssSelector(".settings-page textarea");
    private final By emailInput = By.cssSelector(".settings-page input[type='email']");
    private final By passwordInput = By.cssSelector(".settings-page input[type='password']");
    private final By updateSettingsButton = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'Update')]");
    private final By logoutButton = By.xpath("//button[contains(@class,'btn-outline-danger') or contains(.,'Logout')]");


    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void fillOutForm(String img, String username, String bio, String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(imageUrlInput)).sendKeys(img);
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(bioTestInput)).sendKeys(bio);
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
    }

    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateSettingsButton)).click();
    }



}
