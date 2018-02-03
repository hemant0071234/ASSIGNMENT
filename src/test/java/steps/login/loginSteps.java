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

    @Step("User should get navigated to homepage")
    public void userShouldGetNavigatedToHomePage() {

    }
}
