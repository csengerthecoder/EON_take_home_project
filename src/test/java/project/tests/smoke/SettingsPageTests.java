package project.tests.smoke;

import org.junit.jupiter.api.BeforeEach;
import project.baseTest.BaseTest;
import project.pages.SignInPage;

public class SettingsPageTests extends BaseTest {

    @BeforeEach
    public void setupLogin() {
        SignInPage signInPage = homePage.clickSignIn();
        signInPage.fillOutSignInForm("test@test.com", "asd123");
        signInPage.clickSignInButton();
    }


}
