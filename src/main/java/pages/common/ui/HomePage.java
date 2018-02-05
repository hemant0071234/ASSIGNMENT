package pages.common.ui;

import helpers.ui.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Page{

    @FindBy(linkText = "logout")
    public WebElement logoutLink;

    @FindBy(id="header-bottom-right")
    public WebElement headerBottom;

    @FindBy(xpath = "//div[starts-with(@id,'thing_t3_')]/a")
    public List<WebElement> userPosts;

    @FindBy(linkText = "Submit a new link")
    public WebElement submitNewLink;

    @FindBy(linkText = "Submit a new text post")
    public WebElement submitNewTextPost;

    public HomePage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(logoutLink, "Login button");
    }

    public void openAnyPost() throws InterruptedException {
        click(userPosts.get(userPosts.size()-1));
    }

    public void voteAPost(String postToFindText, String voteFlag) throws InterruptedException {
        click(getDriver().findElement(By.xpath("//p[@class='title']//a[contains(text(),'"
                + postToFindText+"')]/../../../../div[@class='midcol likes']//div[@data-event-action='"+voteFlag+"']")));
    }

    public void getCurrentVoteCount(){

    }
}
