package steps.homepage;

import com.thoughtworks.gauge.Step;
import helpers.util.Storage;
import pages.common.ui.HomePage;
import pages.common.ui.Post;

import java.text.DateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

public class homePageSteps {

    @Step("User should get navigated to homepage")
    public void userShouldGetNavigatedToHomePage() throws InterruptedException {
        HomePage homePage = new HomePage();
        Storage.setHomePage(homePage);

        assertThat("Login page should be ready", homePage.isReady());
    }

    @Step("Open any post")
    public void openAnyPost() throws InterruptedException {
        HomePage homePage = Storage.getHomePage();
        homePage.openAnyPost();
        Post post = new Post();
        Storage.setPostPage(post);
        assertThat("Post page should be ready", post.isReady());
    }


    @Step("Write a comment in the post")
    public void writeACommentOnPost() throws InterruptedException {
        Post post = Storage.getPostPage();


        Date today;
        String strDate;
        DateFormat dateFormat;
        dateFormat = DateFormat
                .getDateInstance(DateFormat.LONG);
        today = new Date();
        strDate = dateFormat.format(today);


        post.writeAComment(strDate);

    }
}
