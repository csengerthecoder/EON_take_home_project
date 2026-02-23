package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailInput = By.cssSelector(".auth-page input[type='email']");
    private final By passwordInput = By.cssSelector(".auth-page input[type='password']");
    private final By signInButton = By.cssSelector(".auth-page button[type='submit']");
    private final By goToRegisterLink = By.cssSelector(".auth-page a[href='/register']");

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void fillInFormInput(By locator, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(data);
    }

    public void fillOutSignInForm(String email, String password) {
        fillInFormInput(emailInput, email);
        fillInFormInput(passwordInput, password);
    }
    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public RegisterPage clickNeedAnAccountLink() {
        wait.until(ExpectedConditions.elementToBeClickable(goToRegisterLink)).click();
        return new RegisterPage(driver, wait);
    }

    public boolean isSignInButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(goToRegisterLink)).isDisplayed();
    }
}
