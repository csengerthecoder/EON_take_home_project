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

public class EditArticleTests extends BaseTest {

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
    @Tag("known-issue") //submitting the edit doesnt change anything
    public void testEditArticle() {
        createMyArticle();
        UserProfilePage ownProfilePage = homePage.clickOwnProfilePage();
        String title = ownProfilePage.getFirstArticleTitle();
        ArticlePage articlePage = ownProfilePage.openOwnArticle();
        ArticleEditorPage editPage = articlePage.clickEdit();
        String titleOnEditPage = editPage.getTitleValue();

        Assertions.assertEquals(title, titleOnEditPage);

        String newTitle = "new title";
        editPage.fillOutArticleForm(newTitle, "desc", "body", "tag");
        editPage.clickPublishButton();
        UserProfilePage userProfilePage2 = homePage.clickOwnProfilePage();
        String title2 = userProfilePage2.getFirstArticleTitle();

        Assertions.assertEquals(newTitle, title2);
        Assertions.assertFalse(driver.getCurrentUrl().contains("/article/"));
    }
}
