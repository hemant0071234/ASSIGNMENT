package setup;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import domains.Application;
import domains.User;
import pages.common.ui.Browser;
import pages.common.ui.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class UiDriverSetup {

    @BeforeScenario(tags = {"ValidLogin"})
    public void setupValidUserLogin(ExecutionContext context) throws InterruptedException{
        initiate(context);
    }

    private void initiate(ExecutionContext context) throws InterruptedException {
        startBrowser();
        if (!context.getAllTags().contains("InvalidLogin")) {
            User user = getUser(context);
            new LoginPage().login(user);
            assertThat("Login link should not be visible to user", true);
        }
    }

    private User getUser(ExecutionContext context) {
        if (context.getAllTags().contains("validLogin") ) {
            return User.validUser();
        }
        return User.validUser();
    }

    public void startBrowser() {
        DriverFactory.getDriver();
        String baseUrl = Application.getURL();
        new Browser().navigateTo(baseUrl);
    }
}
