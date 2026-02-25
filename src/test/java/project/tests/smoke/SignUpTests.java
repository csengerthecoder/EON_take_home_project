package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import project.baseTest.BaseTest;
import project.pages.RegisterPage;
import project.pages.SignInPage;

public class SignUpTests extends BaseTest {

    @Test
    void testSuccessfulSignUp() {
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.fillOutSignUpForm("test1", "test@test.com", "asd123");
        registerPage.clickSignUpButton();

        Assertions.assertTrue(homePage.isSettingsButtonDisplayed());
    }

    @Test
    @Tag("known-issue") // can sign up with same email address
    void testDuplicateEmailSignUp() {
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.fillOutSignUpForm("test1", "test@test.com", "asd123");
        registerPage.clickSignUpButton();

        Assertions.assertFalse(homePage.isSettingsButtonDisplayed());
    }

    @ParameterizedTest
    @CsvSource({
            "test1, '', asd123",
            "'', test22@gmail.com, asd123",
            "test33, test33@gmail.com, ''",
            "test33, '', ''",
            "'', test33@gmail.com, ''",
            "'', '', asd123",
            "'', '', ''",
    })
    @Tag("known-issue") //lets you sign up with missing credentials
    void testMissingCredentialSignUps(String username, String email, String password) {
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.fillOutSignUpForm(username, email, password);
        registerPage.clickSignUpButton();

        Assertions.assertFalse(homePage.isSettingsButtonDisplayed());
    }

    @Test
    @Tag("known-issue") //doesnt lend you on the sign in page
    void testGoToSignInPageLink() {
        RegisterPage regPage = homePage.clickRegister();
        regPage.clickAlreadyHaveAnAccountLink();

        Assertions.assertFalse(regPage.isSignUpButtonVisible());
    }
}
