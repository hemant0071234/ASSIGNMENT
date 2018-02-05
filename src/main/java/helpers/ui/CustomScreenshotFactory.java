package helpers.ui;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import setup.DriverFactory;

public class CustomScreenshotFactory implements ICustomScreenshotGrabber {

    //This will be called by Gauge to take only app part in screenshot and not whole screen-display
    public byte[] takeScreenshot() {
        WebDriver driver = DriverFactory.getExistingDriverElseReturnNull();
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } else {
            showError("Skipping screenshot as UI driver doesn't exist");
            return null;
        }
    }

    private void showError(String format, String... args) {
        Gauge.writeMessage(format, args);
        System.err.printf(format, args);
        System.err.println();
    }
}
