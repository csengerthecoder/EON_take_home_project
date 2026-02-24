package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;
import project.pages.SettingsPage;
import project.pages.SignInPage;

public class SettingsPageTests extends BaseTest {

    @BeforeEach
    public void setupLogin() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();
    }

    @Test
    @Tag("known-issue")
    void testSubmittingSettingsChangeSuccessfully() {
        SettingsPage settingsPage = homePage.clickSettings();
        String newUsername = "testUsername";
        settingsPage.fillOutForm("testIMG", newUsername, "testbio", "testEmail", "testPassword");
        settingsPage.clickUpdateButton();

        Assertions.assertEquals(homePage.getUserNameFromNavBar(), newUsername);
    }

    @Test
    void testSubmittingBioChangeSuccessfully() {
        SettingsPage settingsPage = homePage.clickSettings();
        String newBio = "testBio";
        settingsPage.fillOutForm("testIMG", "newUsername", newBio, "testEmail", "testPassword");
        settingsPage.clickUpdateButton();



        Assertions.assertEquals(homePage.getUserNameFromNavBar(), newBio);
    }
}
