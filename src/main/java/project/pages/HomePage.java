package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By homeButton = By.linkText("Home");
    private final By signInButton = By.linkText("Sign in");
    private final By signUpButton = By.linkText("Sign up");



    private final By yourFeedButton = By.linkText("Your Feed");
    private final By globalFeedButton = By.linkText("Global Feed");
    private final By settingsButton = By.linkText("Settings");
    private final By newPostButton = By.linkText("New Post");
    private final By userProfileLink = By.cssSelector("a.nav-link[href^='/@']");
    private final By authorNames = By.className("author");
    private final By articlePreviewLinks = By.className("preview-link");
    private final By favoriteButtons = By.cssSelector(".article-preview button.btn-outline-primary");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
