import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DesiredCap {
    private static AndroidDriver androidDriver;
    public static AndroidDriver desiredCapabilities() throws Exception {
        File appDir = new File("app");
        File app = new File(appDir, "com.zoomcar_2019-04-18.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        cap.setCapability("appPackage", "com.zoomcar");
        cap.setCapability("appActivity", "com.zoomcar.activity.SplashActivity");
        try
        {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    return androidDriver;
    }
}
