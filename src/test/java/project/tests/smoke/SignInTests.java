package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import project.baseTest.BaseTest;
import project.pages.RegisterPage;
import project.pages.SignInPage;

public class SignInTests extends BaseTest {

    @Test
    void testSignInSuccessfully() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();

        Assertions.assertTrue(homePage.isSettingsButtonDisplayed());
    }

    @ParameterizedTest
    @CsvSource({
            "test@gmail.com, ''",
            "'', asd123",
            "'', ''"
    })
    @Tag("known-issue")
    void testSignInWithMissingCredentials(String email, String password) {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm(email, password);
        signInPage.clickSignInButton();

        Assertions.assertFalse(homePage.isSettingsButtonDisplayed());
    }

    @Test
    void testGoToRegisterPageLink() {
        SignInPage signInPage = homePage.clickSignIn();
        RegisterPage regPage = signInPage.clickNeedAnAccountLink();

        Assertions.assertTrue(regPage.isSignUpButtonVisible());
    }
}
