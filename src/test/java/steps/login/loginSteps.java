package steps.login;

import com.thoughtworks.gauge.Step;
import pages.common.ui.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class loginSteps {
    @Step("Valid user login to application")
    public void validLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        assertThat("Login page should be ready", loginPage.isReady());
    }

    @Step("Login to application using <testName> and <testPassword>")
    public void loginToApplicationUsingCredentials(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        assertThat("Login page should be ready", loginPage.isReady());

    }
}
