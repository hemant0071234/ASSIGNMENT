package pages.common.ui;

import helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Page{

    @FindBy(linkText = "logout")
    public WebElement logoutLink;

    @FindBy(id="header-bottom-right")
    public WebElement headerBottom;

    @FindBy(xpath = "//div[starts-with(@id,'thing_t3_')]")
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



}
