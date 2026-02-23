package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By articleTitle = By.cssSelector(".article-page .banner h1");
    private final By articleMeta = By.cssSelector(".article-page .article-meta");
    private final By authorLink = By.cssSelector(".article-page .article-meta a.author, .article-page .article-meta a[href*='@']");
    private final By favoriteArticleButton = By.cssSelector("button:has(i.ion-heart)");
    private final By followAuthorButton = By.cssSelector("button:has(i.ion-plus-round)");
    private final By editArticleButton = By.xpath("//a[contains(@class,'btn-outline-secondary') and contains(.,'Edit Article')]");
    private final By deleteArticleButton = By.xpath("//button[contains(@class,'btn-outline-danger') and contains(.,'Delete Article')]");
    private final By commentSection = By.name("body");
    private final By postCommentButton = By.xpath("//button[@type='submit' and contains(.,'Post Comment')]");

    public ArticlePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isArticleTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle)).isDisplayed();
    }
}
