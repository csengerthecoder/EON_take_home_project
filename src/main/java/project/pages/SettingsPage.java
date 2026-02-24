package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By imageUrlInput = By.cssSelector("input[name='image']");
    private final By usernameInput = By.cssSelector("input[name='username']");
    private final By bioTestInput = By.cssSelector("textarea[name='bio']");
    private final By emailInput = By.cssSelector("input[name='email']");
    private final By passwordInput = By.cssSelector("input[name='password']");
    private final By updateSettingsButton = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'Update')]");
    private final By logoutButton = By.xpath("//button[contains(@class,'btn-outline-danger') or contains(.,'Logout')]");


    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    private void clearAndType(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void fillOutForm(String img, String username, String bio, String email, String password) {
        clearAndType(imageUrlInput, img);
        clearAndType(usernameInput, username);
        clearAndType(bioTestInput, bio);
        clearAndType(emailInput, email);
        clearAndType(passwordInput, password);
    }

    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateSettingsButton)).click();
    }



}
