package pages.common.ui;

import helpers.ui.Page;
import helpers.util.Storage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

    @FindAll({
            @FindBy(xpath="//div[contains(@class,'upmod')]"),
            @FindBy(xpath="//div[contains(@class,'up')]"),
            @FindBy(xpath="//div[contains(@class,'downmod')]"),
            @FindBy(xpath="//div[contains(@class,'down')]")
    })
    public WebElement postlike;

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
        Storage.setComment(postToFindText);
        Storage.setVote(voteFlag);
        waitForPageLoad();
        String xpath="//p[@class='title']//a[contains(text(),'"
                +postToFindText+"')]/../../../..//div[starts-with(@class,'midcol')]//div[@data-event-action='"+voteFlag+"']";
        WebElement elm = getDriver().findElement(By.xpath(xpath));
        click(elm);
    }

    public boolean postlikeCount(){
        if(Storage.getVote().equals("upvote")) {
            String voteXpath = "//p[@class='title']//a[contains(text(),'"+Storage.getComment()+"')]/../../../..//div[starts-with(@class,'midcol likes')]";
            WebElement elm = getDriver().findElement(By.xpath(voteXpath));
            return isElementVisible(elm);
        }else{
            String voteXpath = "//p[@class='title']//a[contains(text(),'"+Storage.getComment()+"')]/../../../..//div[starts-with(@class,'midcol dislikes')]";
            WebElement elm = getDriver().findElement(By.xpath(voteXpath));
            return isElementVisible(elm);
        }
    }
}
