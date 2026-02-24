package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By articleTitle = By.cssSelector(".article-page .banner h1");
    private final By commentSection = By.name("body");
    private final By postCommentButton = By.xpath("//button[@type='submit' and contains(.,'Post Comment')]");
    private final By commentBodies = By.cssSelector(".card-text");

    private final By favoriteArticleButton = By.cssSelector("button:has(i.ion-heart)");
    private final By followAuthorButton = By.cssSelector("button:has(i.ion-plus-round)");

    private final By editArticleButton = By.xpath("//a[contains(@class,'btn-outline-secondary') and contains(.,'Edit Article')]");
    private final By deleteArticleButton = By.xpath("//button[contains(@class,'btn-outline-danger') and contains(.,'Delete Article')]");


    public ArticlePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isArticleTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle)).isDisplayed();
    }

    public void addComment(String comment) {
        wait.until(ExpectedConditions.elementToBeClickable(commentSection)).sendKeys(comment);
        wait.until(ExpectedConditions.elementToBeClickable(postCommentButton)).click();
    }

    public void toggleFavorite() {
        WebElement favButton = wait.until(ExpectedConditions.elementToBeClickable(favoriteArticleButton));
        String before = favButton.getText();
        favButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(favoriteArticleButton, before)));
    }

    public void toggleFollow() {
        WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(followAuthorButton));
        String before = followButton.getText();
        followButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(followAuthorButton, before)));
    }

    public ArticleEditorPage clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editArticleButton)).click();
        return new ArticleEditorPage(driver, wait);
    }

    public boolean isDeleteButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteArticleButton)).isDisplayed();
    }

    public boolean isEditButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(editArticleButton)).isDisplayed();
    }

    public boolean isCommentVisible(String comment) {
        return wait.until(driver -> driver.findElements(commentBodies).stream().anyMatch(element -> element.getText().contains(comment)));
    }

    public String getFollowButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(followAuthorButton)).getText();
    }

    public String getFavoriteButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteArticleButton)).getText();
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteArticleButton)).click();
    }
}
