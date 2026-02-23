package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailInput = By.cssSelector(".auth-page input[type='email']");
    private final By passwordInput = By.cssSelector(".auth-page input[type='password']");
    private final By signInButton = By.cssSelector(".auth-page button[type='submit']");

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
