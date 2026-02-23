package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticleEditorPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By titleInput = By.cssSelector("input[placeholder='Article Title']");
    private final By descriptionInput = By.cssSelector("input[placeholder=\"What's this article about?\"]");
    private final By bodyTextarea = By.cssSelector("textarea[placeholder='Write your article (in markdown)']");
    private final By tagsInput = By.cssSelector("input[placeholder='Enter tags']");
    private final By publishButton = By.xpath("//button[contains(@class,'btn-primary') and contains(.,'Publish')]");

    // !! BUG !! there's a tag-list element, but nothing comes up.
    // !! BUG !! the placeholder keeps the data from the previously added article, even after refresh or logout-new login

    public ArticleEditorPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
