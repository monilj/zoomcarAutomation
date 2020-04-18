import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class zoomTest {
    static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void driverInstance() throws Exception {
        driver = DesiredCap.desiredCapabilities();
    }

    @Test(priority = 1)
    public void testMobileHorizontalScroll() throws InterruptedException {
        AndroidElement scrollToSelectCity = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).setAsHorizontalList().scrollIntoView("
                                + "new UiSelector().textStartsWith(\"GET\"))"));
        scrollToSelectCity.click();
        String verifyText = driver.findElement(By.id("text_popular_cities")).getText();
        Assert.assertTrue(verifyText.equals("POPULAR CITIES"));
    }

    @Test(priority = 2)
    public void testMobileVerticalScroll() throws InterruptedException {
        AndroidElement scrollToDesiredCity = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"MADURAI\"))"));
        scrollToDesiredCity.click();
        driver.findElementByAccessibilityId("Navigate up").click();
        String desiredCity = driver.findElementById("text_city").getText();
        System.out.printf(desiredCity);
        Assert.assertTrue(desiredCity.equalsIgnoreCase("MADURAI"));

    }
}