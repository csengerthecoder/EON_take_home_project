package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By bannerTitle = By.cssSelector(".banner h1");
    private final By signInButton = By.linkText("Sign in");
    private final By signUpButton = By.linkText("Sign up");

    private final By globalFeedTab = By.xpath("//button[normalize-space()='Global Feed']");
    private final By articlePreviews = By.cssSelector(".article-preview");
    private final By previewAuthor = By.cssSelector(".article-preview .author");
    private final By popularTags = By.cssSelector(".sidebar .tag-list a.tag-pill");
    private final By previewTags = By.cssSelector(".article-preview .tag-list .tag-pill");

    private final By settingsButton = By.cssSelector("a[href='/settings']");
    private final By newArticleButton = By.linkText("New Post");
    private final By userProfileButton = By.cssSelector("a.nav-link[href^='/@']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public RegisterPage clickRegister() {
        click(signUpButton);
        return new RegisterPage(driver, wait);
    }
    public SettingsPage clickSettings() {
        click(settingsButton);
        return new SettingsPage(driver, wait);
    }
    public SignInPage clickSignIn() {
        click(signInButton);
        return new SignInPage(driver, wait);
    }
    public ArticleEditorPage clickNewArticle() {
        click(newArticleButton);
        return new ArticleEditorPage(driver, wait);
    }
    public UserProfilePage clickOwnProfilePage() {
        click(userProfileButton);
        return new UserProfilePage(driver, wait);
    }

    public boolean isBannerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bannerTitle)).isDisplayed();
    }
    public boolean isSettingsButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(settingsButton)).isDisplayed();
    }
    public boolean isSignInButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).isDisplayed();
    }

    public void clickGlobalFeed() {
        click(globalFeedTab);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(articlePreviews));
    }

    public ArticlePage openFirstArticleNotBy(String myUsername) {
        clickGlobalFeed();

        var previews = driver.findElements(articlePreviews);
        for (var preview : previews) {
            String author = preview.findElement(previewAuthor).getText();
            if (!author.equalsIgnoreCase(myUsername)) {
                preview.findElement(By.cssSelector("a.preview-link")).click();
                return new ArticlePage(driver, wait);
            }
        }
        throw new RuntimeException("No non-user article found in Global Feed.");
    }

    public String clickFirstPopularTag() {
        var tag = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(popularTags)).get(0);
        String text = tag.getText().trim();
        tag.click();
        return text;
    }

    public int getArticleCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(articlePreviews)).size();
    }

    public boolean firstArticleHasTag(String tagString) {
        return wait.until(driver -> driver.findElements(previewTags).stream()
                .map(element -> element.getText().trim())
                .anyMatch(tag -> tag.equalsIgnoreCase(tagString)));
    }

    public String getUserNameFromNavBar() {
        return wait.until(ExpectedConditions.elementToBeClickable(userProfileButton)).getAttribute("value");
    }
}
