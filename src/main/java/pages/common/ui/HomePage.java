package pages.common.ui;

import helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

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
        int postIndex = userPosts.size();
        if(postIndex>1) {
            Random rn = new Random();
            postIndex = rn.nextInt(postIndex) + 1;
        }
        click(userPosts.get(postIndex));

    }
}
