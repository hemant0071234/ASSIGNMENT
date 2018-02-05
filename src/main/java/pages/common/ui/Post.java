package pages.common.ui;

import helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Post extends Page {

    @FindBy(xpath = "//textarea[@data-event-action='comment']")
    public WebElement texComment;

    @FindBy(xpath = "//div[@class='usertext-buttons']/button[text()='save']")
    public List<WebElement> btnSave;

    @FindBy(xpath = "//div[starts-with(@id,'siteTable_t3')]//div[starts-with(@id,'thing_t1_')]")
    public List<WebElement> listOfComments;

    @FindBy(xpath = "//div[starts-with(@id,'siteTable_t3')]//div[starts-with(@id,'thing_t1_')]//input[@name='thing_id']")
    public List<String> listOfCommentsText;

    public Post() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(texComment, "Comment area should be displayed");
    }

    public void writeAComment(String comment) throws InterruptedException {
        click(texComment);
        fill(texComment, "Comment area").with(comment);
        click(btnSave.get(1));
    }

    public boolean addedCommentShouldBeVisibleInPost(String addedComment){
        return listOfCommentsText.contains(addedComment);
    }


}
