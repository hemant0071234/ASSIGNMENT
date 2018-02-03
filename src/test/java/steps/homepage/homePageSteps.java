package steps.homepage;

import com.thoughtworks.gauge.Step;
import pages.common.ui.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class homePageSteps {

    @Step("User should get navigated to homepage")
    public void userShouldGetNavigatedToHomePage() throws InterruptedException {

        HomePage homePage = new HomePage();

        assertThat("Login page should be ready", homePage.isReady());
    }
}
