import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class zoomTest {

        private static AndroidDriver androidDriver;

        @BeforeTest
        public void desiredCapabilities() throws Exception {
        File appDir = new File("app");
        File app = new File(appDir, "com.zoomcar_2019-04-18.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("appPackage", "com.zoomcar");
        cap.setCapability("appActivity", "com.zoomcar.activity.SplashActivity");
        try
        {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
                //swipeHorizontal((AndroidDriver) androidDriver,0.01,0.9,0.5,3000);
                swipeHorizontal((AndroidDriver) androidDriver,0.9,0.01,0.5,3000);
        System.out.printf("sssdasdasdasdad");
}

@Test
public void swipeHorizontal(AndroidDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction(androidDriver).press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
        System.out.printf("sssssss");
}

}
