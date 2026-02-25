package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import project.baseTest.BaseTest;
import project.pages.ArticleEditorPage;
import project.pages.ArticlePage;
import project.pages.SignInPage;

public class NewArticleTests extends BaseTest {
    @BeforeEach
    public void setupLogin() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();
    }

    @Test
    void testCreateNewArticleSuccessfully() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.fillOutArticleForm("testTitle", "testDescription", "testBodyText", "testTags");
        ArticlePage article = editorPage.clickPublishButton();

        Assertions.assertTrue(article.isArticleTitleVisible());
    }

    @Test
    @Tag("known-issue") //refresh doesnt load the new article, but article is created
    void testCreateNewArticleSuccessfullyAfterRefresh() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.fillOutArticleForm("testTitle", "testDescription", "testBodyText", "testTags");
        ArticlePage article = editorPage.clickPublishButton();

        Assertions.assertTrue(article.isArticleTitleVisible());
        driver.navigate().refresh();
        Assertions.assertTrue(article.isArticleTitleVisible());
    }

    @ParameterizedTest
    @CsvSource({
            "test, test, test, ''",
            "test, test, '', test",
            "test, '', test, test",
            "'', test, test, test",
    })
    @Tag("known-issue") //should give an error for not being able to send request with missing body
    void testCreateNewArticleWithMissingCredentials(String title, String description, String bodyText, String tags) {
        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.fillOutArticleForm(title, description, bodyText, tags);
        ArticlePage article = editorPage.clickPublishButton();

        Assertions.assertFalse(article.isArticleTitleVisible());
    }

    @Test
    @Tag("known-issue") // refreshing or coming back after changing pages doesnt clear the placeholders
    void testInputFieldsClearedAfterSuccessfulCreation() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.fillOutArticleForm("title", "description", "bodyText", "tags");
        editorPage.clickPublishButton();
        ArticleEditorPage editorPage2 = homePage.clickNewArticle();

        Assertions.assertTrue(editorPage2.isAllInputFieldValueCleared());
    }
}
