package pages.common.ui;

import helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Post extends Page{

    @FindBy(xpath = "//div[@class='usertext-edit md-container']//textarea")
    public WebElement texComment;

    @FindBy(xpath = "//button[text()='save']")
    public WebElement btnSave;

    public Post() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(texComment, "Comment area should be displayed");
    }

    public void writeAComment(String comment) throws InterruptedException {
        fill(texComment,"Comment area").with(comment);
        click(btnSave);
    }

}
