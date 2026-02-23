package project.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput = By.cssSelector(".auth-page input[placeholder='Username'], .auth-page input[name='username']");
    private final By emailInput = By.cssSelector(".auth-page input[type='email']");
    private final By passwordInput = By.cssSelector(".auth-page input[type='password']");
    private final By signUpButton = By.cssSelector(".auth-page button[type='submit']");

    // !! BUG !! have an account doesnt load login

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


}
