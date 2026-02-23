package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;
import project.pages.SettingsPage;
import project.pages.SignInPage;

public class LogoutTest extends BaseTest {

    @Test
    void testLogoutSuccessfully() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();

        SettingsPage settingsPage = homePage.clickSettings();
        settingsPage.logout();

        Assertions.assertTrue(homePage.isSignInButtonDisplayed());
    }
}
