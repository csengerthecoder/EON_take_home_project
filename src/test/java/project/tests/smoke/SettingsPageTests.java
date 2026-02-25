package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;
import project.pages.SettingsPage;
import project.pages.SignInPage;
import project.pages.UserProfilePage;

public class SettingsPageTests extends BaseTest {

    @BeforeEach
    public void setupLogin() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();
    }

    @Test
    @Tag("known-issue")
    void testSubmittingSettingsChange() {
        SettingsPage settingsPage = homePage.clickSettings();
        String newUsername = "testUsername";
        settingsPage.fillOutForm("testIMG", newUsername, "testbio", "testEmail@testEmail.com", "testPassword");
        settingsPage.clickUpdateButton();

        Assertions.assertEquals(homePage.getUserNameFromNavBar(), newUsername);
    }

    @Test
    @Tag("known-issue")
    void testSubmittingBioChange() {
        SettingsPage settingsPage = homePage.clickSettings();
        String newBio = "testBio";
        settingsPage.fillOutForm("testIMG", "newUsername", newBio, "testEmail@testEmail.com", "testPassword");
        settingsPage.clickUpdateButton();

        UserProfilePage profilePage = homePage.clickOwnProfilePage();

        Assertions.assertEquals(newBio, profilePage.getBioText());
    }
    @Test
    void testSubmittingEmailAndPasswordChange() {
        SettingsPage settingsPage = homePage.clickSettings();
        String newEmail = "testEmail@testEmail.com";
        String newPassword = "testPassword";
        settingsPage.fillOutForm("testIMG", "newUsername", "newBio", newEmail, newPassword);
        settingsPage.clickUpdateButton();

        settingsPage.logout();
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm(newEmail, newPassword);
        signInPage.clickSignInButton();

        Assertions.assertTrue(homePage.isSignInButtonDisplayed());
    }
}
