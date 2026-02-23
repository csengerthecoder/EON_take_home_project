package project.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameInput = By.cssSelector(".auth-page input[placeholder='Username'], .auth-page input[name='username']");
    private final By emailInput = By.cssSelector(".auth-page input[type='email']");
    private final By passwordInput = By.cssSelector(".auth-page input[type='password']");
    private final By signUpButton = By.cssSelector(".auth-page button[type='submit']");
    private final By goToLoginLink = By.cssSelector(".auth-page a[href='/register']");

    // !! BUG !! have an account doesnt load login (it links to register)

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void fillInInput(By locator, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(data);
    }

    public void fillOutSignUpForm(String username, String email, String password) {
        fillInInput(usernameInput, username);
        fillInInput(emailInput, email);
        fillInInput(passwordInput, password);
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }




}
