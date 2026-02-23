package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;
import project.pages.RegisterPage;

public class SignUpTests extends BaseTest {

    @Test
    void testSuccessfulSignUp() {
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.fillOutSignUpForm("test1", "test@test.com", "asd123");
        registerPage.clickSignUpButton();

        Assertions.assertTrue(homePage.isSettingsButtonDisplayed());
    }

    @Test
    @Tag("known-issue")
    void testDuplicateEmailSignUp() {
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.fillOutSignUpForm("test1", "test@test.com", "asd123");
        registerPage.clickSignUpButton();

        Assertions.assertFalse(homePage.isSettingsButtonDisplayed());
    }
}
