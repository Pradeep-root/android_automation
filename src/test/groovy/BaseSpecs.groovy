import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Specification
import utills.AndroidHelper
import utills.Helper

class BaseSpecs extends Specification{
    AppiumDriver driver
    Helper helper

    def setup(){
        String platform = System.getProperties().getProperty("platform")

        switch (platform){
            case "android":
                File appDir = new File("binaries")
                File app = new File(appDir,"app-debug.apk")
                DesiredCapabilities capabilities = new DesiredCapabilities()
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223WQ5K")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath())
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120)
                capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.myapplication")
                capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.myapplication.MainActivity")
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
                driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities)
                helper = new AndroidHelper(driver)
                break
            // Can add ios platform here if want to test the ios app too
            default:
                throw new IllegalStateException("Unsupported platform: "+ platform)
        }


    }

    def cleanup(){
        if(driver != null) driver.quit()
    }
}