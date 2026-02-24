package project.pages;

import org.apache.commons.io.StreamIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    private void fillOutInput(By locator, String data) {
        var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(data);
    }

    public void fillOutArticleForm(String title, String description, String bodyText, String tags) {
        fillOutInput(titleInput, title);
        fillOutInput(descriptionInput, description);
        fillOutInput(bodyTextarea, bodyText);
        fillOutInput(tagsInput, tags);
    }
    public ArticlePage clickPublishButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(publishButton)).click();
        return new ArticlePage(driver, wait);
    }

    public boolean isAllInputFieldValueCleared() {
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput)).getAttribute("value");
        String description = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionInput)).getAttribute("value");
        String body = wait.until(ExpectedConditions.visibilityOfElementLocated(bodyTextarea)).getAttribute("value");
        String tags = wait.until(ExpectedConditions.visibilityOfElementLocated(tagsInput)).getAttribute("value");

        return title.isEmpty() && description.isEmpty() && body.isEmpty() && tags.isEmpty();
    }

    public String getTitleValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput)).getAttribute("value");
    }
}
