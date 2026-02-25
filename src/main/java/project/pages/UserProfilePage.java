package project.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By editProfileSettingsLink = By.xpath("//a[contains(@class,'btn-outline-secondary') and normalize-space()='Edit Profile Settings']");

    private final By myArticlesTab = By.xpath("//a[contains(@class,'nav-link') and normalize-space()='My Articles']");
    private final By favoritedArticlesTab = By.xpath("//button[@type='button' and contains(@class,'nav-link') and normalize-space()='Favorited Articles']");
    private final By articleTitle = By.cssSelector(".article-page h1");
    private final By articleTitles = By.cssSelector(".article-preview h1");
    private final By bioText = By.xpath("//img[contains(@class,'user-img')]/following-sibling::p");

    public UserProfilePage(WebDriver driver,  WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getFirstArticleTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle)).getText();
    }

    public SettingsPage openProfileSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(editProfileSettingsLink)).click();
        return new SettingsPage(driver, wait);
    }

    public ArticlePage openOwnArticle() {
        if (!driver.findElements(myArticlesTab).isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(myArticlesTab)).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(articleTitle)).click();
        return new ArticlePage(driver, wait);
    }

    public String getBioText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bioText)).getText();
    }

    public List<String> getAllArticleTitles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitles));

        return driver.findElements(articleTitles)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void openFavoritedArticles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(favoritedArticlesTab)).click();
    }

}