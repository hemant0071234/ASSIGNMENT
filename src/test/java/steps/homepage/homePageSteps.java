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

    @Step("Write <test comment> as a comment in the post")
    public void writeACommentOnPost(String comment) throws InterruptedException {
        Post post = Storage.getPostPage();
        post.writeAComment(comment);
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

        Storage.setComment(strDate);
        post.writeAComment(strDate);
    }

    @Step("Added comment should be visible in the post")
    public void addecCommentShouldBeVisibleInPost() {
        Post post = Storage.getPostPage();
        assertThat("Added comment is not displayed", post.addedCommentShouldBeVisibleInPost(Storage.getComment()));
    }

    @Step("Vote a post having text < text> with <upvote>")
    public void votePostWithFlag(String postTitleText, String voteFlag) throws InterruptedException {
        HomePage homePage = Storage.getHomePage();
        homePage.voteAPost(postTitleText, voteFlag);
    }

    @Step("Vote should be updated")
    public void voteShouldBeUpdated() {
        HomePage homePage = Storage.getHomePage();
        assertThat("Post vote count should be updated", homePage.onVotePostLikeCountShouldChange());
    }
}
