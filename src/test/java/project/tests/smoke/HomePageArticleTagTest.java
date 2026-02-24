package project.tests.smoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.baseTest.BaseTest;

public class HomePageArticleTagTest extends BaseTest {
    @Test
    void testClickPopularTagFiltersByCheckingPreviewTags() {
        String tag = homePage.clickFirstPopularTag();

        Assertions.assertTrue(homePage.getArticleCount() > 0);
        Assertions.assertTrue(homePage.firstArticleHasTag(tag));
    }
}
