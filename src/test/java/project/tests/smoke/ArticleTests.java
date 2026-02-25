package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;
import project.pages.ArticleEditorPage;
import project.pages.ArticlePage;
import project.pages.SignInPage;
import project.pages.UserProfilePage;

public class ArticleTests extends BaseTest {
    private final String myUsername = "test-user-1";

    @BeforeEach
    public void setupLogin() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();
    }

    private ArticlePage createMyArticle() {
        ArticleEditorPage editor = homePage.clickNewArticle();
        editor.fillOutArticleForm("title", "desc", "body", "tag");
        ArticlePage articlePage = editor.clickPublishButton();

        return articlePage;
    }

    @Test
    void testCanCommentToOwnArticle() {
        ArticlePage article = createMyArticle();
        String comment = "hello";
        article.addComment(comment);

        Assertions.assertTrue(article.isCommentVisible(comment));
    }

    @Test
    void testEditButtonOpensEditPage() {
        ArticlePage article = createMyArticle();

        Assertions.assertTrue(article.isEditButtonVisible());
        ArticleEditorPage editorPage = article.clickEdit();

        Assertions.assertFalse(editorPage.getTitleValue().isEmpty());
    }

    @Test
    @Tag("known-issue") //The delete button doesnt do anything (probably no request sent)
    void testCanDeleteOwnArticle() {
        ArticlePage article = createMyArticle();

        Assertions.assertTrue(article.isDeleteButtonVisible());
        article.clickDelete();

        Assertions.assertFalse(driver.getCurrentUrl().contains("/article/"));
    }

    @Test
    void testToggleFavorite() {
        ArticlePage article = homePage.openFirstArticleNotBy(myUsername);
        String favBefore = article.getFavoriteButtonText();
        article.toggleFavorite();
        String favAfter = article.getFavoriteButtonText();
        Assertions.assertNotEquals(favBefore, favAfter);
    }

    @Test
    void testToggleFollow() {
        ArticlePage article = homePage.openFirstArticleNotBy(myUsername);
        String followBefore = article.getFollowButtonText();
        article.toggleFollow();
        String followAfter = article.getFollowButtonText();
        Assertions.assertNotEquals(followBefore, followAfter);
    }

    @Test
    @Tag("known-issue") //flaky. no usable locator for favorite tab
    void testFavoriteArticleExistsInOwnFavoriteArticleTab() {
        homePage.clickGlobalFeed();
        String title = homePage.getFirstPreviewTitle();
        System.out.println(title);
        homePage.favoriteFirstArticle();
        UserProfilePage profile = homePage.clickOwnProfilePage();
        profile.openFavoritedArticles();
        System.out.println(profile.getAllArticleTitles());

        Assertions.assertTrue(profile.getAllArticleTitles().contains(title));
    }

    @Test
    void testCanCommentOnOthersArticle() {
        ArticlePage article = homePage.openFirstArticleNotBy(myUsername);
        String comment = "nice";
        article.addComment(comment);

        Assertions.assertTrue(article.isCommentVisible(comment));
    }
}
