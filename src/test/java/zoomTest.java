import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class zoomTest {

        private static AndroidDriver androidDriver;


public static void main(String[] args) {
        File appDir = new File("app");
        File app = new File(appDir, "zoomCar.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //cap.setCapability("appPackage", "com.zoomcar");
        //cap.setCapability("appActivity", "com.zoomcar.activity.OnboardingActivity");
        try
        {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        }

        catch(MalformedURLException e) {
            e.printStackTrace();
        }
}
}
