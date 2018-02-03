package pages.common.ui;

import domains.User;
import helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id="user_login")
    public WebElement user_login;

    @FindBy(id="passwd_login")
    public WebElement passwd_login;

    @FindBy(xpath = "//button[text()='log in']")
    public WebElement loginBtn;


    public LoginPage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(loginBtn, "Login button");
    }

    public boolean login(User user) throws InterruptedException {
        waitForPageLoad();
        click(loginLink);
        waitForElementToBeVisible(loginBtn,"Login button should be dipslayed");
        fill(user_login, "Username").with(user.getUsername());
        fill(passwd_login, "Password").with(user.getPassword());
        waitForLoginButtonToEnable();
        Thread.sleep(500);
        click(loginBtn, "Login button");
        return isElementNotDisplayed(loginLink, "Login button");
    }

    public boolean login(String userName, String password) throws InterruptedException {
        waitForPageLoad();
        click(loginLink);
        fill(user_login, "Username").with(userName);
        fill(passwd_login, "Password").with(password);
        waitForLoginButtonToEnable();
        Thread.sleep(500);
        click(loginBtn, "Login button");
        return isElementNotDisplayed(loginLink, "Login button");
    }

    private void waitForLoginButtonToEnable() throws InterruptedException {
        waitForElementToNotHaveClassNameAttribute(loginBtn, "disabled");
    }

}
