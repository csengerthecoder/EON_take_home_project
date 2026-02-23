package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By articleTitle = By.cssSelector(".article-page .banner h1");
    private final By articleMeta = By.cssSelector(".article-page .article-meta");
    private final By authorLink = By.cssSelector(".article-page .article-meta a.author, .article-page .article-meta a[href*='@']");
    private final By favoriteArticleButton = By.cssSelector("button:has(i.ion-heart)");
    private final By followAuthorButton = By.cssSelector("button:has(i.ion-plus-round)");



    public ArticlePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

}
